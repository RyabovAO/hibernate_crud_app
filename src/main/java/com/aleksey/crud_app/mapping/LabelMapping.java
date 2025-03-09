package com.aleksey.crud_app.mapping;

import com.aleksey.crud_app.model.Label;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LabelMapping {

    public static List<Label> labelMapping(ResultSet resultSet) {
        List<Label> labelList = new ArrayList<>();
        Label selectLabel = null;
        int currentLabelId = -1;

        try {
            while (resultSet.next()) {

                int LabelId = resultSet.getInt("writer.id");
                if (currentLabelId != LabelId) {
                    selectLabel = new Label();
                    selectLabel.setId(LabelId);
                    selectLabel.setName(resultSet.getString("label.name"));

                    labelList.add(selectLabel);

                    currentLabelId = LabelId;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return labelList;
    }
}
