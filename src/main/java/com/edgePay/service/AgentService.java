package com.edgePay.service;

import com.edgePay.model.Agent;
import com.edgePay.model.ResponseModel;
import com.edgePay.repository.AgentRepository;
import com.edgePay.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Date;

@Service
public class AgentService {
    private final UserRepository userRepository;
    private final AgentRepository agentRepository;

    public AgentService(UserRepository userRepository, AgentRepository agentRepository) {
        this.userRepository = userRepository;
        this.agentRepository = agentRepository;
    }

    public ResponseEntity<ResponseModel> addAgent(Agent agent, Principal principal){
        try {
            if (check(agent))
                return new ResponseEntity<ResponseModel>( new ResponseModel("01", "User Already Exist", agent), HttpStatus.CONFLICT);

//            agent.setRegisteredBy(userService.getUserByUsername(principal.getName()).getId());
//            endUser.setRoleGroup(roleGroupService.getRoleGroup(endUser.getRoleGroupType()));
            agent.setCreatedAt(new Date());
            agentRepository.save(agent);
            return new ResponseEntity<ResponseModel>( new ResponseModel("00", "Success", agent), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<ResponseModel>( new ResponseModel("99", "Error Occurred", agent), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ResponseModel> getAgentByUsername(String username){
        try {
            Agent agent = (Agent) userRepository.findByUsername(username);

            if (agent == null)
                return new ResponseEntity<ResponseModel>( new ResponseModel("02", "Not Found", agent), HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<ResponseModel>( new ResponseModel("00", "Success", agent), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<ResponseModel>( new ResponseModel("99", "Error Occurred", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ResponseModel> getAgentTransactions(Agent agent){
        return new ResponseEntity<ResponseModel>( new ResponseModel("99", "Error Occurred", agent), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public boolean check(Agent agent){

        return userRepository.findByUsername(agent.getUsername()) != null;
    }
}
