package br.pucrs.school_system.dtos;

public class ResponseDto<T> {
  private boolean success;
  private T message;

  public ResponseDto(T message) {
    this.success = true;
    this.message = message;
  }

  public ResponseDto(String message) {
    this.success = false;
    this.message = (T) message;
  }

  public boolean isSuccess() {
    return success;
  }

  public T getMessage() {
    return message;
  }

  public void setMessage(T message) {
    this.message = message;
  }
}
