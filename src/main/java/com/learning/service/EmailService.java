package com.learning.service;

import com.learning.model.EmailDetails;

public interface EmailService {

    void sendSimpleEmail(EmailDetails emailDetails);

    void sendEmailWithAttachment(EmailDetails emailDetails);

}
