(function(window) {
	var canvas_a;
	var block_a;
	const l = 42, // 滑块边长
		r = 10, // 滑块半径
		w = 310, // canvas宽度
		h = 155, // canvas高度
		PI = Math.PI
	const L = l + r * 2 // 滑块实际边长

	function getRandomNumberByRange(start, end) {
		return Math.round(Math.random() * (end - start) + start)
	}

	function createCanvas(width, height) {
		const canvas = createElement('canvas')
		canvas.width = width
		canvas.height = height
		return canvas
	}

	function createImg(onload) {
		const img = createElement('img')
		img.crossOrigin = "Anonymous"
		img.onload = onload
		img.onerror = () => {
			img.src = getRandomImg()
		}
		img.src = getRandomImg()
		return img
	}

	function createElement(tagName) {
		return document.createElement(tagName)
	}

	function addClass(tag, className) {
		tag.classList.add(className)
	}

	function removeClass(tag, className) {
		tag.classList.remove(className)
	}

	function getRandomImg() {
		return 'https://picsum.photos/300/150/?image=' + getRandomNumberByRange(0, 100)
	}

	function draw(ctx, operation, x, y) {
		ctx.beginPath()
		ctx.moveTo(x, y)
		ctx.lineTo(x + l / 2, y)
		ctx.arc(x + l / 2, y - r + 2, r, 0, 2 * PI)
		ctx.lineTo(x + l / 2, y)
		ctx.lineTo(x + l, y)
		ctx.lineTo(x + l, y + l / 2)
		ctx.arc(x + l + r - 2, y + l / 2, r, 0, 2 * PI)
		ctx.lineTo(x + l, y + l / 2)
		ctx.lineTo(x + l, y + l)
		ctx.lineTo(x, y + l)
		ctx.lineTo(x, y)
		ctx.fillStyle = '#fff'
		ctx[operation]()
		ctx.beginPath()
		ctx.arc(x, y + l / 2, r, 1.5 * PI, 0.5 * PI)
		ctx.globalCompositeOperation = "xor"
		ctx.fill()
	}

	function sum(x, y) {
		return x + y
	}

	function square(x) {
		return x * x
	}

	class jigsaw {
		constructor(el, success, fail, xb, yb) {
			this.el = el
			this.success = success
			this.fail = fail
			this.x = xb
			this.y = yb
		}

		init() {
			this.initDOM()
			this.initImg()
			this.draw()
			this.bindEvents()
		}

		initDOM() {
			const canvas = createCanvas(w, h) // 画布

			const block = canvas.cloneNode(true) // 滑块
			const sliderContainer = createElement('div')
			const refreshIcon = createElement('div')
			const sliderMask = createElement('div')
			const slider = createElement('div')
			const sliderIcon = createElement('span')
			const text = createElement('span')

			block.className = 'block'
			sliderContainer.className = 'sliderContainer'
			refreshIcon.className = 'refreshIcon'
			sliderMask.className = 'sliderMask'
			slider.className = 'slider'
			sliderIcon.className = 'sliderIcon'
			text.innerHTML = '向右滑动滑块填充拼图'
			text.className = 'sliderText'

			const el = this.el
			el.appendChild(canvas)
			el.appendChild(refreshIcon)
			el.appendChild(block)
			slider.appendChild(sliderIcon)
			sliderMask.appendChild(slider)
			sliderContainer.appendChild(sliderMask)
			sliderContainer.appendChild(text)
			el.appendChild(sliderContainer)
			canvas_a = canvas;
			block_a = block
			Object.assign(this, {
				canvas,
				block,
				sliderContainer,
				refreshIcon,
				slider,
				sliderMask,
				sliderIcon,
				text,
				canvasCtx: canvas.getContext('2d'),
				blockCtx: block.getContext('2d')
			})
		}

		initImg() {
			const img = createImg(() => {
				this.canvasCtx.drawImage(img, 0, 0, w, h)
				this.blockCtx.drawImage(img, 0, 0, w, h)
				const y = this.y - r * 2 + 2
				const ImageData = this.blockCtx.getImageData(this.x, y, L, L)
				this.block.width = L
				this.blockCtx.putImageData(ImageData, 0, y)
			})
			this.img = img
		}

		draw() {
			var phoneNo = $("#phone-number").val().trim();
			if(null != phoneNo && 'undefind' != phoneNo && "" != phoneNo) {
				var xx, yy;
				var canvas_b = this.canvasCtx;
				var block_b = this.blockCtx;

				$.ajax({
					async: false,
					url: host + "/generator/position?xMax=260&yMax=100&phoneNo=" + phoneNo,
					success: function(result) {
						var obje = JSON.parse(result);
						xx = obje.data.x
						yy = obje.data.y
						draw(canvas_b, 'fill', xx, yy)
						draw(block_b, 'clip', xx, yy)
					}
				});
				this.x = xx
				this.y = yy
			}
		}

		clean() {
			this.canvasCtx.clearRect(0, 0, w, h)
			this.blockCtx.clearRect(0, 0, w, h)
			this.block.width = w
		}

		bindEvents() {
			this.el.onselectstart = () => false
			this.refreshIcon.onclick = () => {
				this.reset()
			}

			let originX, originY, trail = [],
				isMouseDown = false
			this.slider.addEventListener('mousedown', function(e) {
				originX = e.x, originY = e.y
				isMouseDown = true
			})
			document.addEventListener('mousemove', (e) => {
				if(!isMouseDown) return false
				const moveX = e.x - originX
				const moveY = e.y - originY
				if(moveX < 0 || moveX + 38 >= w) return false
				this.slider.style.left = moveX + 'px'
				var blockLeft = (w - 40 - 20) / (w - 40) * moveX
				this.block.style.left = blockLeft + 'px'

				addClass(this.sliderContainer, 'sliderContainer_active')
				this.sliderMask.style.width = moveX + 'px'
				trail.push(moveY)
			})
			document.addEventListener('mouseup', (e) => {
				if(!isMouseDown) return false
				isMouseDown = false
				if(e.x == originX) return false
				removeClass(this.sliderContainer, 'sliderContainer_active')
				this.trail = trail
				//const {
				//spliced,
				//TuringTest
				//} = this.verify()
				const arr = this.trail // 拖动时y轴的移动距离
				const average = arr.reduce(sum) / arr.length // 平均值
				const deviations = arr.map(x => x - average) // 偏差数组
				const stddev = Math.sqrt(deviations.map(square).reduce(sum) / arr.length) // 标准差
				const left = parseInt(this.block.style.left)
				//return {
				//spliced: Math.abs(left - this.x) < 10,
				//TuringTest: average !== stddev, // 只是简单的验证拖动轨迹，相等时一般为0，表示可能非人为操作
				//}
				var spliced, TuringTest;
				var thisx = this.x;
				var phoneNo = $("#phone-number").val().trim();
				var thisy = this.y;
				var that = this;
				$.ajax({
					async: false,
					url: host + "/send/messageCheckPosition?xPosition=" + left + "&phoneNo=" + phoneNo+'&yPosition='+thisy,
					success: function(result) {
						var obje = JSON.parse(result);
						//spliced = Math.abs(left - thisx) < 10
						TuringTest = average !== stddev // 只是简单的验证拖动轨迹，相等时一般为0，表示可能非人为操作
						if(parseInt(obje.code) == 0) {
							console.log(1111)
							if(TuringTest) {
								addClass(that.sliderContainer, 'sliderContainer_success')
								that.success && that.success()
							} else {
								addClass(that.sliderContainer, 'sliderContainer_fail')
								that.text.innerHTML = '再试一次'
								that.reset()
							}
						} else {
							console.log(22222)
							addClass(that.sliderContainer, 'sliderContainer_fail')
							that.fail && that.fail()
							setTimeout(() => {
								that.reset()
							}, 1000)
						}
						return false;
					}
				});
//				if(spliced) {
//					if(TuringTest) {
//						addClass(this.sliderContainer, 'sliderContainer_success')
//						this.success && this.success()
//					} else {
//						addClass(this.sliderContainer, 'sliderContainer_fail')
//						this.text.innerHTML = '再试一次'
//						this.reset()
//					}
//				} else {
//					addClass(this.sliderContainer, 'sliderContainer_fail')
//					this.fail && this.fail()
//					setTimeout(() => {
//						this.reset()
//					}, 1000)
//				}
			})
		}

		verify() {
			const arr = this.trail // 拖动时y轴的移动距离
			const average = arr.reduce(sum) / arr.length // 平均值
			const deviations = arr.map(x => x - average) // 偏差数组
			const stddev = Math.sqrt(deviations.map(square).reduce(sum) / arr.length) // 标准差
			const left = parseInt(this.block.style.left)
			var phoneNo = $("#phone-number").val().trim();
			$.ajax({
				async: true,
				url: host + "/generator/position?xMax=260&yMax=100&phoneNo=" + phoneNo,
				success: function(result) {
					var obje = JSON.parse(result);
					return {
						spliced: Math.abs(left - this.x) < 10,
						TuringTest: average !== stddev, // 只是简单的验证拖动轨迹，相等时一般为0，表示可能非人为操作
					}
				}
			});
		}

		reset() {
			this.sliderContainer.className = 'sliderContainer'
			this.slider.style.left = 0
			this.block.style.left = 0
			this.sliderMask.style.width = 0
			this.clean()
			this.img.src = getRandomImg()
			this.draw()
		}

	}

	window.jigsaw = {

		init: function(element, success, fail) {
			var phoneNo = $("#phone-number").val().trim();
			$.ajax({
				url: host + "/generator/position?xMax=260&phoneNo=111&yMax=100" + phoneNo,
				success: function(result) {
					var obje = JSON.parse(result);
					new jigsaw(element, success, fail, obje.data.x, obje.data.y).init()
				}
			});
		}
	}
}(window))

function sleep(d) {
	var t = Date.now();
	while(Date.now - t <= d);
}