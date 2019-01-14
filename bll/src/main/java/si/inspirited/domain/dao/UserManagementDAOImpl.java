package main.java.si.inspirited.domain.dao;

public class UserManagementDAOImpl implements UserManagementDAO{

    public UserManagementDAOImpl() {
        System.out.println("call UserManagementDAO Implementation init");
    }

    @Override
    public boolean createUser(String newUserData) {
        System.out.println("call UserManagementDAO Implementation createUser()");
        return false;
    }
}
