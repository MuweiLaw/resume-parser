package com.dc.common.util.resume.parser;

import com.dc.common.util.resume.domain.TrainingExperience;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 培训经历类
 * @ClassName: TrainingExperienceParser
 * @Version: v1.0.0
 * @Author: Murray Law
 * @Date 2019/12/20 18:23
 */
public class TrainingExperienceParser extends BaseParser {

    public TrainingExperienceParser(String content) {
        super(content);
    }

    public List<TrainingExperience> parse() {
        List<TrainingExperience> trainingExps = new ArrayList<>();
        Elements elements = root.getElementsMatchingOwnText("培训经历");
        if (elements.size() > 0) {
            if (elements.first().getElementsByAttributeValue("", "font-size: 14px;").size() > 0) {
                return matchTrainByZhuoPin(trainingExps, elements);
            }
        }
        return trainingExps;
    }

    private List<TrainingExperience> matchTrainByZhuoPin(List<TrainingExperience> trainingExps, Elements elements) {
        Element element = elements.first().parent().parent().parent().parent().parent();
        TrainingExperience training = new TrainingExperience();
        while (element.child(0).getElementsByAttributeValue("style", "color: #000; font-weight: bold; font-size: 12px; line-height: 20px; padding-top: 8px; padding-bottom: 2px;").size() > 0 || element.child(0).getElementsByAttributeValue("style", "line-height: 18px; padding-left: 19px; font-size: 12px; padding-bottom: 10px;").size() > 0) {
            training.setInstitution(element.getElementsMatchingOwnText("培训机构：").first().text().split("：")[1]);
            trainingExps.add(training);
        }
        return trainingExps;
    }

}
