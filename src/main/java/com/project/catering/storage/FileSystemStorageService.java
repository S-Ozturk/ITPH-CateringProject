package com.project.catering.storage;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileSystemStorageService implements StorageService {

    private final Path rootLocation;

    @Autowired
    public FileSystemStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public void store(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
            	BufferedImage originalImage = ImageIO.read(inputStream);
            	
            	  // Get image dimensions
            	  int height = originalImage.getHeight();
            	  int width = originalImage.getWidth();            	  
            	  
            	  // The image is already a square
            	 /* if (height == width) {
            	    return originalImage;
            	  }*/
            	  
            	  // Compute the size of the square
            	  int squareSize = (height > width ? width : height);
            	  
            	  // Coordinates of the image's middle
            	  int xc = width / 2;
            	  int yc = height / 2;
            	  // Crop
            	  BufferedImage croppedImage = originalImage.getSubimage(
            	      xc - (squareSize / 2), // x coordinate of the upper-left corner
            	      yc - (squareSize / 2), // y coordinate of the upper-left corner
            	      squareSize,            // widht
            	      squareSize             // height
            	  );
            	  
            	  Image tmp = croppedImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            	  BufferedImage resized = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);

            	  Graphics2D g2d = resized.createGraphics();
            	  g2d.drawImage(tmp, 0, 0, null);
            	  g2d.dispose();
            	  
            	  ByteArrayOutputStream os = new ByteArrayOutputStream();
            	  ImageIO.write(resized, "gif", os);
            	  InputStream cropped = new ByteArrayInputStream(os.toByteArray());
            	  Files.copy(cropped, this.rootLocation.resolve(filename),
                          StandardCopyOption.REPLACE_EXISTING);
               /* Files.copy(inputStream, this.rootLocation.resolve(filename), ---ORJİNAL WORKİNG CODE---
                    StandardCopyOption.REPLACE_EXISTING);*/
            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }
    }
    
    @Override
    public void store(MultipartFile file, String filename) {

    	file.getOriginalFilename().replace(file.getOriginalFilename(), filename);

        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
            	BufferedImage originalImage = ImageIO.read(inputStream);
            	
            	  // Get image dimensions
            	  int height = originalImage.getHeight();
            	  int width = originalImage.getWidth();            	  
            	  
            	  // The image is already a square
            	 /* if (height == width) {
            	    return originalImage;
            	  }*/
            	  
            	  // Compute the size of the square
            	  int squareSize = (height > width ? width : height);
            	  
            	  // Coordinates of the image's middle
            	  int xc = width / 2;
            	  int yc = height / 2;
            	  // Crop
            	  BufferedImage croppedImage = originalImage.getSubimage(
            	      xc - (squareSize / 2), // x coordinate of the upper-left corner
            	      yc - (squareSize / 2), // y coordinate of the upper-left corner
            	      squareSize,            // widht
            	      squareSize             // height
            	  );
            	  
            	  Image tmp = croppedImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            	  BufferedImage resized = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);

            	  Graphics2D g2d = resized.createGraphics();
            	  g2d.drawImage(tmp, 0, 0, null);
            	  g2d.dispose();
            	  
            	  ByteArrayOutputStream os = new ByteArrayOutputStream();
            	  ImageIO.write(resized, "png", os);
            	  InputStream cropped = new ByteArrayInputStream(os.toByteArray());
            	  Files.copy(cropped, this.rootLocation.resolve(filename),
                          StandardCopyOption.REPLACE_EXISTING);
               /* Files.copy(inputStream, this.rootLocation.resolve(filename), ---ORJİNAL WORKİNG CODE---
                    StandardCopyOption.REPLACE_EXISTING);*/
            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                .filter(path -> !path.equals(this.rootLocation))
                .map(this.rootLocation::relativize);
        }
        catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);

            }
        }
        catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        }
        catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }
}
