package org.example.appdomain.repository;

import org.example.appdomain.models.*;

import java.util.*;

public interface AptDao {

    Optional<Apartment> findByNr(int nr);
}
