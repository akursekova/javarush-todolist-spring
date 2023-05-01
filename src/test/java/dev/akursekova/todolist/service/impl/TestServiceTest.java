//package dev.akursekova.todolist.service.impl;
//
//
//import dev.akursekova.todolist.dao.TaskDao;
//import dev.akursekova.todolist.domain.Task;
//import dev.akursekova.todolist.service.TaskService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//
//@ExtendWith(MockitoExtension.class)
//class TestServiceTest {
//
//    @InjectMocks
//    private TaskService taskService;
//    @Mock
//    private TaskDao taskDao;
//
//
////    @Test
////    void should_find_country_by_id() {
////        when(countryRepository.findById(1L)).thenReturn(Optional.of(new Country()));
////        when(countryMapper.mapToDTO(any(Country.class))).thenReturn(new CountryDTO());
////
////        var actual = countryService.getCountryById(1L);
////        assertNotNull(actual);
////
////        verify(countryRepository, times(1)).findById(1L);
////        verify(countryMapper, times(1)).mapToDTO(any(Country.class));
////    }
//
//    @Test
//    void should_find_task_by_id() {
//        when(taskService.getById(1)).thenReturn(new Task());
//
//        var actual = taskService.getById(1);
//        assertNotNull(actual);
//
////        verify(taskDao, times(1)).findById(1L);
//        verify(taskDao, times(1)).getById(1);
//    }
//
////    @Test
////    void should_return_first_page() {
////        Pageable pageable = PageRequest.of(0, 10);
////        when(countryRepository.findAll(pageable)).thenReturn(new PageImpl<>(new ArrayList<>()));
////
////        var actual = countryService.getCountry(pageable);
////        assertNotNull(actual);
////        assertInstanceOf(PageDTO.class, actual);
////
////        verify(countryRepository, times(1)).findAll(pageable);
////    }
//
//
//}