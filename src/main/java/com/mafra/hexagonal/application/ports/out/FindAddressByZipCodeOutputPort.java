package com.mafra.hexagonal.application.ports.out;

import com.mafra.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
