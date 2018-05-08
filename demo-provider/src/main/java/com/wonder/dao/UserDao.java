package com.wonder.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface UserDao {
    ArrayList<Map> findAllUser(HashMap map);
}
