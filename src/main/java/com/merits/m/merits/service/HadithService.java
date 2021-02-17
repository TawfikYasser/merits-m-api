package com.merits.m.merits.service;

import com.merits.m.merits.Model.Hadith;
import com.merits.m.merits.dao.IHadith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HadithService {

    private final IHadith iHadith;

    @Autowired
    public HadithService(@Qualifier("DB") IHadith hadith) {
        this.iHadith = hadith;
    }

    public List<Hadith> getAllHadith() {
        return iHadith.getAllHadith();
    }
}
