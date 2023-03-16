package com.example.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongodb.model.HealthEvaluation;
import com.example.mongodb.repository.HealthEvaluationRepository;

@Service
public class HealthEvaluationService {

    @Autowired
    private HealthEvaluationRepository repository;

    public HealthEvaluation addHealthEvaluation(HealthEvaluation HealthEvaluation) {
        return repository.save(HealthEvaluation);
    }

    public List<HealthEvaluation> findAllHealthEvaluations() {
        return repository.findAll();
    }

    public HealthEvaluation getHealthEvaluationByFormCode(String formCode) {
        return repository.findById(formCode).get();
    }

    public HealthEvaluation updateHealthEvaluation(HealthEvaluation HERequest) {
        HealthEvaluation existingForm = repository.findById(HERequest.getFormCode()).get();
        existingForm.setFormCode(HERequest.getFormCode());
        existingForm.setDate(HERequest.getDate());
        existingForm.setFormName(HERequest.getFormName());
        existingForm.setFormCompleted(HERequest.isFormCompleted());
        existingForm.setFormApproved(HERequest.isFormApproved());
        // existingForm.setRevisionNum(HERequest.getRevisionNum());
        existingForm.setAttendance(HERequest.getAttendance());
        existingForm.setToolBox(HERequest.getToolBox());
        existingForm.setCompliance(HERequest.getCompliance());
        existingForm.setPromotionalActivities(HERequest.getPromotionalActivities());
        existingForm.setSubmission(HERequest.getSubmission());

        existingForm.setTrainingCourse(HERequest.getTrainingCourse());
        existingForm.setTradeCourse(HERequest.getTradeCourse());
        existingForm.setSafetyTalk(HERequest.getSafetyTalk());
        existingForm.setWSHSupervisor(HERequest.getWSHSupervisor());
        existingForm.setOtherTraining(HERequest.getOtherTraining());

        existingForm.setEffort(HERequest.getEffort());
        existingForm.setPermitToWork(HERequest.getPermitToWork());
        existingForm.setFrequencyRate(HERequest.getFrequencyRate());
        existingForm.setSafetyOffence(HERequest.getSafetyOffence());
        existingForm.setSafetyRectification(HERequest.getSafetyRectification());
        
        existingForm.setCuttingTool(HERequest.getCuttingTool());
        existingForm.setLadder(HERequest.getLadder());
        existingForm.setLiftingGear(HERequest.getLiftingGear());
        existingForm.setElectricalEquipment(HERequest.getElectricalEquipment());
        existingForm.setOtherMachineries(HERequest.getOtherMachineries());

        existingForm.setCommitmentHS(HERequest.getCommitmentHS());
        existingForm.setPPECompliance(HERequest.getPPECompliance());
        existingForm.setSiteCleaniness(HERequest.getSiteCleaniness());
        existingForm.setStoreCleaniness(HERequest.getStoreCleaniness());
        existingForm.setQuarterCleaniness(HERequest.getQuarterCleaniness());

        existingForm.setScore(HERequest.getScore());
        existingForm.setComments(HERequest.getComments());

        existingForm.setSafetyCoordinator(HERequest.getSafetyCoordinator());
        existingForm.setSafetyCoordinatorSignature(HERequest.getSafetyCoordinatorSignature());
        existingForm.setSafetyCoordinatorEvaluationDate(HERequest.getSafetyCoordinatorEvaluationDate());

        existingForm.setDirector(HERequest.getDirector());
        existingForm.setDirectorSignature(HERequest.getDirectorSignature());
        existingForm.setDirectorApprovalDate(HERequest.getDirectorApprovalDate());
        return repository.save(existingForm);
    }

    public String deleteHealthEvaluation(String formCode) {
        repository.deleteById(formCode);
        return formCode + " deleted from dashboard";
    }
}

