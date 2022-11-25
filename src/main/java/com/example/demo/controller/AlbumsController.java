package com.example.demo.controller;

import com.example.demo.response.AlbumRest;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

  @GetMapping
  public List<AlbumRest> getAlbums() {

    final var album1 = new AlbumRest("userId1",
        "albumId1",
        "Title 1",
        "Description 1",
        "http://localhost:8082/albums/1");
    final var album2 = new AlbumRest("userId1",
        "albumId2",
        "Title 1",
        "Description 2",
        "http://localhost:8082/albums/2");

    return Arrays.asList(album1, album2);
  }
}
