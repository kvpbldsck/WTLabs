package org.kvp_bld_sck.BookDatabase.transport.commands.impl;

import org.kvp_bld_sck.BookDatabase.entity.Profile;
import org.kvp_bld_sck.BookDatabase.entity.UserSession;
import org.kvp_bld_sck.BookDatabase.service.ProfileService;
import org.kvp_bld_sck.BookDatabase.service.ServiceFabric;
import org.kvp_bld_sck.BookDatabase.transport.commands.Command;
import org.kvp_bld_sck.BookDatabase.transport.exception.CannotExecuteException;

public class GetProfileByIdCommand implements Command {
    private ProfileService profileService = ServiceFabric.getFabric().getProfileService();

    @Override
    public Object execute(Object... params) throws CannotExecuteException {
        try {
            profileService.getProfile((Integer) params[0], (UserSession) params[1]);
            return true;
        } catch (Exception e) {
            throw new CannotExecuteException("cannot get profile by id", e);
        }
    }
}