package com.wonder.service;

import java.util.HashMap;

public interface UserService {
    HashMap<String,Object> findAllUser(String key, int pageIndex, int pageSize, String sortField, String sortOrder);
}
