package com.nine.publishing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nine.publishing.domain.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {
}
