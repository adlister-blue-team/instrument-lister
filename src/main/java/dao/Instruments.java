package dao;

import models.Instrument;

import java.util.List;

public interface Instruments {

    //get a list of all the instruments
    List<Instrument> getAllInstruments();

    //get instrument by id
    Instrument getInstrumentById(long id);

    //insert a new ad and return the new instrument's id
    Long insertInstrument(Instrument instrument);

    //update instrument and return id of updated instrument
    long updateInstrument(long id, Instrument instrument);

    //return true if deleted instrument
    boolean deleteInstrument(long id);

    List<String> getInstrumentTypes(long id);

    List<Instrument> searchInstrumentsByName(String name);
}
