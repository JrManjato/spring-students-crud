package com.example.studentcrud.repository;

import com.example.studentcrud.model.Students;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@Service
@AllArgsConstructor
public class StudentRepositoryJPQLImpl implements IStudentRepJPQL{
  private IStudentRepJPQL re;
  @Override
  public List<Students> findAll() {
    return re.findAll();
  }

  @Override
  public List<Students> findAll(Sort sort) {
    return null;
  }

  @Override
  public Page<Students> findAll(Pageable pageable) {
    return null;
  }

  @Override
  public List<Students> findAllById(Iterable<Long> longs) {
    return null;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void deleteById(Long id) {
    re.deleteById(id);
  }

  @Override
  public void delete(Students entity) {

  }

  @Override
  public void deleteAllById(Iterable<? extends Long> longs) {

  }

  @Override
  public void deleteAll(Iterable<? extends Students> entities) {

  }

  @Override
  public void deleteAll() {

  }

  @Override
  public <S extends Students> S save(S entity) {
    return null;
  }

  @Override
  public <S extends Students> List<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public Optional<Students> findById(Long aLong) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(Long aLong) {
    return false;
  }

  @Override
  public void flush() {

  }

  @Override
  public <S extends Students> S saveAndFlush(S entity) {
    return null;
  }

  @Override
  public <S extends Students> List<S> saveAllAndFlush(Iterable<S> entities) {
    return null;
  }

  @Override
  public void deleteAllInBatch(Iterable<Students> entities) {

  }

  @Override
  public void deleteAllByIdInBatch(Iterable<Long> longs) {

  }

  @Override
  public void deleteAllInBatch() {

  }

  @Override
  public Students getOne(Long aLong) {
    return null;
  }

  @Override
  public Students getById(Long aLong) {
    return null;
  }

  @Override
  public Students getReferenceById(Long aLong) {
    return null;
  }

  @Override
  public <S extends Students> Optional<S> findOne(Example<S> example) {
    return Optional.empty();
  }

  @Override
  public <S extends Students> List<S> findAll(Example<S> example) {
    return null;
  }

  @Override
  public <S extends Students> List<S> findAll(Example<S> example, Sort sort) {
    return null;
  }

  @Override
  public <S extends Students> Page<S> findAll(Example<S> example, Pageable pageable) {
    return null;
  }

  @Override
  public <S extends Students> long count(Example<S> example) {
    return 0;
  }

  @Override
  public <S extends Students> boolean exists(Example<S> example) {
    return false;
  }

  @Override
  public <S extends Students, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
    return null;
  }
}
