package com.aleksey.crud_app.view;

import com.aleksey.crud_app.controller.LabelController;
import com.aleksey.crud_app.model.Label;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;
import java.util.Scanner;

@RequiredArgsConstructor
public class LabelView {
    private final LabelController labelController;
    private final Scanner scanner = new Scanner(System.in);

    public LabelView() {
        this.labelController = new LabelController();
    }

    public void createLabel() {
        System.out.println("Enter name");
        String name = scanner.nextLine();

        Label createdLabel = labelController.createLabel(name);

        System.out.println("Created label: " + createdLabel);
    }

    public void updateLabel() {
        System.out.println("Enter label id");
        long id = Long.parseLong(scanner.nextLine());

        System.out.println("Enter new name");
        String newName = scanner.nextLine();

        Label updateLabel = labelController.updateLabel(id, newName);

        System.out.println("label with id update to: " + updateLabel);
    }

    public void getLabel() {
        System.out.println("Enter label id");
        int id = scanner.nextInt();
        Label receivedLabel = labelController.getLabelById(id);
        System.out.println("Label with ID: " + receivedLabel.toString());
    }

    public void getAllLabel() {
        labelController.getAllLabel().forEach(l -> System.out.println(l.toString()));
    }

    public void deleteLabel() {
        System.out.println("Enter label id");
        long id = scanner.nextLong();
        labelController.deleteLabelById(id);
        System.out.println("Label with id: " + id + " delete");
    }
}