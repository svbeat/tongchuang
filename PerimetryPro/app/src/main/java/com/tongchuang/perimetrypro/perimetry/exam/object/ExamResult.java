package com.tongchuang.perimetrypro.perimetry.exam.object;


import com.google.gson.Gson;
import com.tongchuang.perimetrypro.perimetry.exam.ExamTask;
import com.tongchuang.perimetrypro.perimetry.settings.ExamSettings;
import com.tongchuang.perimetrypro.perimetry.stimulus.StimulusRunner;
import com.tongchuang.perimetrypro.perimetry.stimulus.object.StimulusResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qingdi on 4/15/16.
 */
public class ExamResult {
    public static final String DUMMY_PATIENT_ID="dummyPatient";
    public static final int AMPLIFICATION=3;
    private int     id;
    private String  patientId;
    private long    examDate;
    private String  uploaded;
    private Integer     serverId;
    private String  testDeviceId;

    private String  deviceSettingsVersion;
    private String  patientSettingsVersion;

    private ExamSettings.EXAM_FIELD_OPTION examFieldOption;

    private Map<String, String> examResult;
    private Map<String, List<StimulusResponse>> allResponses;

    public ExamResult() {
    }

    public ExamResult(String patientId, long examDate, String result, String uploaded) {
        super();
        this.patientId = patientId;
        this.examDate = examDate;
        this.uploaded = uploaded;
    }

    public ExamResult(ExamTask exam) {
        this.examDate = System.currentTimeMillis();
        this.uploaded = "N";

        this.deviceSettingsVersion = exam.getExamSettings().getDeviceSettingsVersion();
        this.patientSettingsVersion = exam.getExamSettings().getPatientSettingsVersion();
        this.examFieldOption = exam.getExamSettings().getExamFieldOption();

        examResult = new HashMap<String, String>();
        allResponses = new HashMap<String, List<StimulusResponse>>();
        List<StimulusRunner> runners = exam.getStimulusRunners();
        for (StimulusRunner r : runners) {
            examResult.put(r.getPositionCode(), r.getFinalResult());
            allResponses.put(r.getPositionCode(), r.getAllResponses());

        }
    }

    //getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public long getExamDate() {
        return examDate;
    }

    public void setExamDate(long examDate) {
        this.examDate = examDate;
    }

    public String getUploaded() {
        return uploaded;
    }

    public void setUploaded(String uploaded) {
        this.uploaded = uploaded;
    }

    public String getTestDeviceId() {
        return testDeviceId;
    }

    public void setTestDeviceId(String testDeviceId) {
        this.testDeviceId = testDeviceId;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public String toJSon() {
        Gson gson = new Gson();
        return gson.toJson(this, ExamResult.class);
    }

    @Override
    public String toString() {
        return "ExamResult{" +
                "id=" + id +
                ", patientId='" + patientId + '\'' +
                ", examDate=" + examDate +
                ", uploaded='" + uploaded + '\'' +
                ", serverId=" + serverId +
                ", testDeviceId='" + testDeviceId + '\'' +
                '}';
    }
}
