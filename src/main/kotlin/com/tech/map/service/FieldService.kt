package com.tech.map.service



import com.tech.map.model.Field
import com.tech.map.repository.FieldRepository
import org.springframework.stereotype.Service

@Service
class FieldService(private val fieldRepository: FieldRepository) {


    fun getAll(): MutableIterable<Field> {
        return fieldRepository.findAll()
    }
    fun getByID(id: Int): Field {
        return fieldRepository.findById(id).orElse(null)
    }
    fun add(field: Field) {
        fieldRepository.save(field)
    }
    fun remove(id: Int) {
        fieldRepository.deleteById(id)
    }
    fun update(field: Field) {
        fieldRepository.save(field)
    }


}