package com.f1zwy.task_service.dto;

public class RequestDTO {
    public record AuthRequest(String username, String password) {}

    public record AuthResponse(String token) {}
}