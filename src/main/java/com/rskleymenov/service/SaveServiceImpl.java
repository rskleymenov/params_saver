package com.rskleymenov.service;

import com.rskleymenov.entity.SaveParamsEntity;
import com.rskleymenov.model.SaveParamsModel;
import com.rskleymenov.repository.SaveParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Service
public class SaveServiceImpl implements SaveService {

    @Autowired
    private SaveParameterRepository saveParameterRepository;

    @Override
    @Transactional
    public SaveParamsModel save(String stationName, String action) {
        SaveParamsModel saveParamsModel = new SaveParamsModel();
        saveParamsModel.setStationName(stationName);
        saveParamsModel.setAction(action);
        SaveParamsEntity saveParamsEntity = mapToEntity(saveParamsModel);
        SaveParamsEntity savedEntity = this.saveParameterRepository.save(saveParamsEntity);
        return mapToModel(savedEntity);
    }

    @Override
    @Transactional
    public List<SaveParamsModel> retrieveAll() {
        Iterable<SaveParamsEntity> paramsEntities = this.saveParameterRepository.findAll();
        return StreamSupport
                .stream(paramsEntities.spliterator(), false)
                .map(this::mapToModel)
                .collect(toList());
    }


    private SaveParamsEntity mapToEntity(final SaveParamsModel saveParamsModel) {
        SaveParamsEntity saveParamsEntity = new SaveParamsEntity();
        saveParamsEntity.setStationName(saveParamsModel.getStationName());
        saveParamsEntity.setAction(saveParamsModel.getAction());
        saveParamsEntity.setSavedTime(new Date());
        return saveParamsEntity;
    }

    private SaveParamsModel mapToModel(final SaveParamsEntity saveParamsEntity) {
        SaveParamsModel saveParamsModel = new SaveParamsModel();
        saveParamsModel.setId(saveParamsEntity.getId());
        saveParamsModel.setStationName(saveParamsEntity.getStationName());
        saveParamsModel.setAction(saveParamsEntity.getAction());
        saveParamsModel.setSavedTime(saveParamsEntity.getSavedTime());
        return saveParamsModel;
    }
}
