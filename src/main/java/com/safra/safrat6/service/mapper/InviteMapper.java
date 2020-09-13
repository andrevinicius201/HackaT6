package com.safra.safrat6.service.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.safra.safrat6.entity.InviteEntity;
import com.safra.safrat6.model.Invite;

@Component
public class InviteMapper {

  public InviteEntity toEntity(Invite invite) {
    InviteEntity entity = new InviteEntity();
    entity.setDescription(invite.getDescription());
    entity.setInvitationDate(invite.getDateInvite());
    entity.setInvitedEmail(invite.getEmail());
    entity.setId(invite.getId());
    entity.setMadeEffective(invite.isEffectice());
    return entity;
  }

  public List<Invite> toModel(List<InviteEntity> entities) {
    return entities.stream().map(this::toModel).collect(Collectors.toList());
  }
  
  public Invite toModel(InviteEntity entity) {
    Invite invite = new Invite();
    invite.setDateInvite(entity.getInvitationDate());
    invite.setDescription(entity.getDescription());
    invite.setEffectice(entity.getMadeEffective());
    invite.setEmail(entity.getInvitedEmail());
    invite.setId(entity.getId());
    return invite;
  }

}
