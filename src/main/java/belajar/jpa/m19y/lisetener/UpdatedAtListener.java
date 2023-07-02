package belajar.jpa.m19y.lisetener;

import belajar.jpa.m19y.entity.UpdatedAtAware;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class UpdatedAtListener {

  @PrePersist // dipanggil sebelum di save ke database
  @PreUpdate  // dipanggil setelah di save ke database
  public void setListenerUpdatedAt(UpdatedAtAware object){
    object.setUpdatedAt(LocalDateTime.now());
  }
}
