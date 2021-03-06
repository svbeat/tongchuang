package com.vvavy.visiondemo.service;

import android.graphics.Point;

import com.vvavy.visiondemo.object.Intensity;
import com.vvavy.visiondemo.object.PerimetryStimulus;

import java.util.List;

/**
 * Created by qingdi on 4/6/16.
 */
public interface PerimetryTestService {

    public void processStimulus(PerimetryStimulus currentStimulus);
    public int getPromptTime();

    public boolean isDone();

    public List<PerimetryStimulus> getExamResult();

    public int getStimulusX(PerimetryStimulus s);
    public int getStimulusY(PerimetryStimulus s);

    public List<Point> getFixations();

    public Intensity getIntensity(int db);

    public enum ExamType {
        LEFT, RIGHT
    }

    public PerimetryStimulus getCurrentStimulus();
    public List<PerimetryStimulus> getStimuli();

    public int getCenterLeftX();

    public int getCenterRightX();

    public int getCenterY();

    public int getRadius();

    public ExamType getExamType();
}
