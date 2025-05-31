package com.f1zwy.task_service.dto;

public class AuthRequestDTO {
    public record AuthRequest(String username, String password) {}
}
