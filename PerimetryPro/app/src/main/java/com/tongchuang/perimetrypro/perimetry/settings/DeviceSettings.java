package com.tongchuang.perimetrypro.perimetry.settings;

import android.graphics.Point;

import com.tongchuang.perimetrypro.perimetry.common.Intensity;

import java.util.Map;

/**
 * Created by qingdi on 8/7/16.
 */
public class DeviceSettings {
    private String      version;
    private Map<Integer, Intensity>     intensities;

    private Integer     stimulateDuration;
    private Integer     stimulateInterval;

    private Integer     stimulusSpacing;
    private Integer     stimulusRadius;
    private Integer     fixationRadius;
    private Point       leftFixation;
    private Point       rightFixation;

    private int         textDisplaySize;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getFixationRadius() {
        return fixationRadius;
    }

    public void setFixationRadius(Integer fixationRadius) {
        this.fixationRadius = fixationRadius;
    }

    public Map<Integer, Intensity> getIntensities() {
        return intensities;
    }

    public void setIntensities(Map<Integer, Intensity> intensities) {
        this.intensities = intensities;
    }

    public Point getLeftFixation() {
        return leftFixation;
    }

    public void setLeftFixation(Point leftFixation) {
        this.leftFixation = leftFixation;
    }

    public Point getRightFixation() {
        return rightFixation;
    }

    public void setRightFixation(Point rightFixation) {
        this.rightFixation = rightFixation;
    }

    public Integer getStimulateDuration() {
        return stimulateDuration;
    }

    public void setStimulateDuration(Integer stimulateDuration) {
        this.stimulateDuration = stimulateDuration;
    }

    public Integer getStimulateInterval() {
        return stimulateInterval;
    }

    public void setStimulateInterval(Integer stimulateInterval) {
        this.stimulateInterval = stimulateInterval;
    }

    public Integer getStimulusRadius() {
        return stimulusRadius;
    }

    public void setStimulusRadius(Integer stimulusRadius) {
        this.stimulusRadius = stimulusRadius;
    }

    public Integer getStimulusSpacing() {
        return stimulusSpacing;
    }

    public void setStimulusSpacing(Integer stimulusSpacing) {
        this.stimulusSpacing = stimulusSpacing;
    }

    public int getTextDisplaySize() {
        return textDisplaySize;
    }

    public void setTextDisplaySize(int textDisplaySize) {
        this.textDisplaySize = textDisplaySize;
    }
}
