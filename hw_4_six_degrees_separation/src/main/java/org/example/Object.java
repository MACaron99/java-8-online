package org.example;

class Object {
    private int id;

    public Object(int id) {
        this.id = id;
    }

    public void sendMessage(Object receiver) {
        System.out.println("Object " + id + " sends a message to object " + receiver.id);
        receiver.receiveMessage();
    }

    public void receiveMessage() {
        System.out.println("Object " + id + " receive a message");
    }
}