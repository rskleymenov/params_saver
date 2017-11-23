package com.rskleymenov.service;

import com.rskleymenov.model.SaveParamsModel;

import java.util.List;

public interface SaveService {

    SaveParamsModel save(final String stationName, final String action);

    List<SaveParamsModel> retrieveAll();

}
