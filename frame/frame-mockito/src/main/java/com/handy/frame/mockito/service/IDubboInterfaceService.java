package com.handy.frame.mockito.service;

import com.handy.frame.mockito.domain.Person;

public interface IDubboInterfaceService {
    Person findPerson(String userName);
}
