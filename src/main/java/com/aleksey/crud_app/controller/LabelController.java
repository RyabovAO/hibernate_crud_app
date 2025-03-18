package com.aleksey.crud_app.controller;

import com.aleksey.crud_app.model.Label;
import com.aleksey.crud_app.repository.jdbc.LabelRepositoryImpl;
import com.aleksey.crud_app.services.LabelService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LabelController {
    private final LabelService labelService;

    public LabelController() {
        this.labelService = new LabelService();
    }

        public Label createLabel(String name) {
        if(name == null) {
            return null;
        }
        Label label = new Label();
        label.setName(name);
        return labelService.createLabel(label);
    }

    public Label updateLabel(Long id, String newName) {
        if(id == 0 || newName == null) {
            return null;
        }
        Label label = new Label();
        label.setId(id);
        label.setName(newName);
        return labelService.updateLabel(label);
    }

    public List<Label> getAllLabel() {
        return labelService.getAllLabel();
    }

    public Label getLabelById(long id) {
        if(id == 0) {
            System.out.println("Uncorrected id");
            return null;
        }
        return labelService.getLabelById(id);
    }

    public void deleteLabelById(long id) {
        if(id == 0) {
            System.out.println("Uncorrected id");
        } else labelService.deleteLabelById(id);

    }
}