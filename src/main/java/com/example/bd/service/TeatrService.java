package com.example.bd.service;

import com.example.bd.model.Teatr;
import com.example.bd.repo.TeatrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * Сервис для методов манипуляций с таблицей театра(афишей мероприятий)
 *
 */
@Service
public class TeatrService {
    /**
     * Репозиторий, содержащий запросы к таблице театра
     */
    @Autowired
    private TeatrRepo teatrRepo;
    /**
     * Метод созданяи экземпляра класса Teatr в таблице teatrs
     *
     * @param teatr экземпляр класса Teatr для обновления
     * @return экземпляр класса Teatr, который был обновлен в таблице teatrs
     */
    public void create(Teatr teatr){ teatrRepo.save(teatr); }
    /**
     * Метод обновления экземпляра класса Teatr в таблице teatrs
     *
     * @param teatr экземпляр класса Teatr для обновления
     * @return экземпляр класса Teatr, который был обновлен в таблице teatrs
     */
    public void update(Teatr teatr){ teatrRepo.save(teatr); }
    /**
     * Метод получения списка всех экземпляров пользовательского класса, содержащихся в таблице teatrs
     *
     * @return all teatrs, содержащийся в таблице teatrs
     */
    public List<Teatr> findAll(){ return teatrRepo.findAll(); }
    /**
     * Метод получения экземпляра класса Teatr по идентификатору театра(мероприятия)
     *
     * @param id идентификатор пароля
     */
    public Optional<Teatr> findById(Long id){ return teatrRepo.findById(id); }
    /**
     * Метод получения экземпляра пользовательского класса, содержащегося в таблице teatrs, по жанру
     *
     * @param genre жанр мероприятия
     */
    public List<Teatr> findByGenre(String genre){
        return teatrRepo.findByGenre(genre);
    }


}


