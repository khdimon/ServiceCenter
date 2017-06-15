package com.softserve.edu.servicecenter.service;

import com.softserve.edu.servicecenter.dao.DAOFactory;
import com.softserve.edu.servicecenter.entity.Team;

import java.util.List;

public class TeamService {
    public void addTeam(Team team) {
        DAOFactory.getInstance().getTeamDAO().addElement(team);
    }

    public void updateTeam(Team team) {
        DAOFactory.getInstance().getTeamDAO().updateElement(team);
    }

    public Team getTeamById(Long teamId) {
        return DAOFactory.getInstance().getTeamDAO()
                .getElementByID(teamId);
    }

    public List<Team> getAllTeam() {
        return DAOFactory.getInstance().getTeamDAO()
                .getAllElements();
    }

    public void deleteTeam(Team team) {
        DAOFactory.getInstance().getTeamDAO()
                .deleteElement(team);
    }
}
