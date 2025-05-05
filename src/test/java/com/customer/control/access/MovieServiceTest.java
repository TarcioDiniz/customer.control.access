package com.customer.control.access;

import com.customer.control.access.business.services.MovieService;
import com.customer.control.access.domain.common.requests.movie.MovieRequest;
import com.customer.control.access.domain.entities.Movie;
import com.customer.control.access.domain.repositories.IMovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {
    @Mock
    IMovieRepository movieRepository;
    @InjectMocks
    MovieService movieService;

    @Test
    void testSave() {
        MovieRequest request = new MovieRequest();
        request.setTitle("Title");
        request.setDescription("Desc");
        request.setReleaseDate(new Date());
        request.setGenre("Genre");
        Movie saved = new Movie();
        saved.setId(1L);
        saved.setTitle("Title");
        when(movieRepository.save(any())).thenReturn(saved);

        Movie result = movieService.save(request);
        assertEquals(1L, result.getId());
        assertEquals("Title", result.getTitle());
    }

    @Test
    void testUpdateNotFound() {
        when(movieRepository.findById(1L)).thenReturn(Optional.empty());
        RuntimeException ex = assertThrows(RuntimeException.class, () -> movieService.update(new MovieRequest(), 1L));
        assertEquals("Movie not found", ex.getMessage());
    }

    @Test
    void testFindById() {
        Movie m = new Movie(); m.setId(1L);
        when(movieRepository.findById(1L)).thenReturn(Optional.of(m));

        Movie result = movieService.findById(1L);
        assertEquals(1L, result.getId());
    }

    @Test
    void testFindAll() {
        when(movieRepository.findAll()).thenReturn(List.of(new Movie(), new Movie()));
        List<Movie> list = movieService.findAll();
        assertEquals(2, list.size());
    }

    @Test
    void testDeleteById() {
        Movie m = new Movie(); m.setId(1L);
        when(movieRepository.findById(1L)).thenReturn(Optional.of(m));

        Movie result = movieService.deleteById(1L);
        verify(movieRepository).deleteById(1L);
        assertEquals(1L, result.getId());
    }

    @Test
    void testSearchByTitle() {
        when(movieRepository.findByTitleContainingIgnoreCase("abc")).thenReturn(List.of());
        List<Movie> list = movieService.searchByTitle("abc");
        assertTrue(list.isEmpty());
    }
}