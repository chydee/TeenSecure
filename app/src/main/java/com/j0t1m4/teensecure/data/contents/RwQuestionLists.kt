package com.j0t1m4.teensecure.data.contents

import com.j0t1m4.teensecure.R

object RwQuestionLists {

    // Level 1: Basic Awareness
    val level1Questions = listOf(
        Question.MultipleChoice(
            question = "What is a common sign of a ransomware infection?", options = listOf("Slow internet speed", "Pop-up messages demanding payment", "New software updates", "Improved computer performance"), correctAnswer = "Pop-up messages demanding payment", 10
        ),
        Question.TrueOrFalse(
            question = "Strong passwords can help protect against ransomware.", correctAnswer = true, 5
        ),
        Question.ScenarioBased(
            scenario = "You receive an email from a friend with an attachment you weren’t expecting.", question = "What should you do?", options = listOf("Open the attachment immediately", "Delete the email", "Confirm with your friend before opening it", "Forward the email to your contacts"), correctAnswer = "Confirm with your friend before opening it", 15
        ),
        Question.FillInTheBlank(
            question = "Regularly __________ your software to protect against ransomware.", correctAnswer = "Update", 10
        ),
        Question.Matching(
            instruction = "Match the actions with their descriptions:",
            pairs = mapOf(
                "Phishing" to "Fake emails to steal information", "Backup" to "Copying data to prevent loss", "Malware" to "Harmful software"
            ),
            correctAnswer = mapOf(
                "Phishing" to "Fake emails to steal information", "Backup" to "Copying data to prevent loss", "Malware" to "Harmful software"
            ),
            reward = 20
        ),
        Question.MultipleAnswer(
            question = "Which of the following are good practices to avoid ransomware? (Select all that apply)", options = listOf("Using strong passwords", "Clicking on unknown links", "Regularly updating software", "Disabling antivirus software"), correctAnswers = listOf("Using strong passwords", "Regularly updating software"), 20
        ),
        Question.InteractiveQuiz(
            question = "What should you do first if you detect ransomware on your computer?", options = listOf("Pay the ransom", "Disconnect from the internet", "Delete all files", "Contact local media"), correctAnswer = "Disconnect from the internet", 10
        ),
        Question.Visual(
            imageUrl = listOf(R.drawable.level_1_question_8), options = listOf("Yes", "No"), question = "Look at this email screenshot. Is it likely to be a phishing attempt?", correctAnswer = "Yes", reward = 10
        ),
        Question.DragAndDrop(
            question = "Organize these steps for a secure backup strategy:",
            items = listOf(
                "Store backups in multiple locations", "Schedule regular backups", "Test your backups", "Use cloud storage"
            ), correctOrder = listOf(
                "Schedule regular backups", "Use cloud storage", "Test your backups", "Store backups in multiple locations"
            ), reward = 20
        ),
        Question.TrueOrFalse(
            question = "It's safe to download software from any website as long as you have antivirus software installed.", correctAnswer = false, 5
        ),
    )

    val level2Questions = listOf(
        Question.MultipleChoice(
            question = "What is the main purpose of ransomware?", options = listOf("To encrypt files and demand a ransom", "To steal personal information", "To disable hardware", "To monitor user activity"), correctAnswer = "To encrypt files and demand a ransom", 10
        ), Question.FillInTheBlank(
            question = "Use __________ to enhance security by requiring more than one form of verification.", correctAnswer = "Multi-factor Authentication", 10
        ), Question.ScenarioBased(
            scenario = "Your computer is infected with ransomware and a pop-up demands payment.", question = "What should you do?", options = listOf("Pay the ransom", "Disconnect from the network and seek professional help", "Ignore the message", "Reboot the computer"), correctAnswer = "Disconnect from the network and seek professional help", 15
        ), Question.Matching(
            instruction = "",
            correctAnswer = mapOf(
                "Antivirus" to "Software that protects against malware", "Multi-Factor Authentication" to "Requires two or more verification methods", "Backup" to "Creates copies of data for recovery"
            ),
            pairs = mapOf(
                "Antivirus" to "Software that protects against malware", "Multi-Factor Authentication" to "Requires two or more verification methods", "Backup" to "Creates copies of data for recovery"
            ), reward = 20
        ), Question.TrueOrFalse(
            question = "Public Wi-Fi is safe to use for online banking if you have a strong password.", correctAnswer = false, 5
        ), Question.MultipleAnswer(
            question = "What actions can help prevent ransomware infections? (Select all that apply)",
            options = listOf("Regular software updates", "Clicking unknown email links", "Using antivirus software", "Avoiding public Wi-Fi for sensitive transactions"),
            correctAnswers = listOf("Regular software updates", "Using antivirus software", "Avoiding public Wi-Fi for sensitive transactions"),
            reward = 20
        ), Question.InteractiveQuiz(
            question = "Why is it important to regularly update your software?", options = listOf("To get new features", "To protect against security vulnerabilities", "To increase speed", "To reduce storage space"), correctAnswer = "To protect against security vulnerabilities", reward = 10
        ),
        Question.Matching(
            instruction = "Match the ransomware prevention method to its benefit:",
            correctAnswer = mapOf(
                "Antivirus" to "Software that protects against malware", "Multi-Factor Authentication" to "Requires two or more verification methods", "Backup" to "Creates copies of data for recovery"
            ),
            pairs = mapOf(
                "Strong passwords" to "Patch vulnerabilities",
                "Antivirus software" to "Harder to guess",
                "Regular updates" to "Detects and removes malware"
            ), reward = 20
        ),
        Question.Visual(
            imageUrl = listOf(R.drawable.level_2_question_9), question = "Is this email likely to be a phishing attempt?", options = listOf(
                "Legitimate Email", "Phishing Email"
            ), correctAnswer = "Phishing Email", reward = 10
        )
    )

    val level3Questions = listOf(
        Question.MultipleChoice(
            question = "Which is NOT a common method ransomware uses to spread?", options = listOf("Phishing emails", "Malicious downloads", "Hardware failure", "Exploiting software vulnerabilities"), correctAnswer = "Hardware failure", reward = 10
        ), Question.TrueOrFalse(
            question = "Backing up data to the cloud ensures it is completely safe from ransomware.", correctAnswer = false, reward = 5
        ), Question.ScenarioBased(
            scenario = "You receive an email from your bank asking to verify your account by clicking a link.",
            question = "What should you do?",
            options = listOf("Click the link and enter your details", "Delete the email", "Contact your bank directly using official contact information", "Forward the email to the bank’s Support"),
            correctAnswer = "Contact your bank directly using official contact information",
            reward = 15
        ), Question.FillInTheBlank(
            question = "To protect against ransomware regularly update your __________ and operating system.", correctAnswer = "Software", reward = 20
        ), Question.Matching(
            instruction = "",
            pairs = mapOf(
                "Encryption" to "Demand for payment to release encrypted files",
                "Ransom Note" to "Manipulating people to divulge confidential information",
                "Social Engineering" to "Protects data by converting it into code"
            ),
            correctAnswer = mapOf(
                "Encryption" to "Protects data by converting it into code", "Ransom Note" to "Demand for payment to release encrypted files", "Social Engineering" to "Manipulating people to divulge confidential information"
            ),
            reward = 20
        ), Question.MultipleAnswer(
            question = "Which of the following are steps to take immediately after a ransomware infection is detected? (Select all that apply)", options = listOf("Disconnect from the internet", "Pay the ransom", "Report the attack to authorities", "Restore data from backups"), correctAnswers = listOf(
                "Disconnect from the internet", "Report the attack to authorities", "Restore data from " + "backups"
            ), reward = 20
        ), Question.InteractiveQuiz(
            question = "What is a sign that your system might be vulnerable to ransomware attacks?", options = listOf("Frequent software updates", "Outdated antivirus definitions", "Use of strong passwords", "Multi-factor authentication"), correctAnswer = "Outdated antivirus definitions", reward = 10
        ), Question.DragAndDrop(
            question = "Arrange these actions in the correct order for responding to a ransomware infection:",
            items = listOf(
                "Disconnect from the network", "Report the attack", "Seek professional help", "Restore data from backups"
            ), correctOrder = listOf(
                "Disconnect from the network", "Report the attack", "Seek professional help", "Restore data from backups"
            ), reward = 20
        ), Question.Visual(
            imageUrl = listOf(R.drawable.level_3_question_9_a, R.drawable.level_3_question_9_b), question = "Identify which of these browser warnings indicates a potentially dangerous website.", options = listOf("A", "B"), correctAnswer = "B", reward = 10
        )
    )

    val level4Questions = listOf(
        Question.MultipleChoice(
            question = "Which feature is essential in antivirus software to protect against ransomware?", options = listOf("Real-time scanning", "Free trials", "User-friendly interface", "Dark mode"), correctAnswer = "Real-time scanning", reward = 10
        ), Question.FillInTheBlank(
            question = "Multi-factor authentication requires a combination of something you know, something you have, and something you __________.", correctAnswer = "Are", reward = 10
        ), Question.ScenarioBased(
            scenario = "Your colleague opens a suspicious attachment and their computer is infected.", question = "What should you do?", options = listOf("Isolate their computer from the network", "Ignore it since it's their problem", "Call the police immediately", "Turn off your computer"), correctAnswer = "Isolate their computer from the network", reward = 15
        ), Question.Matching(
            instruction = "",
            pairs = mapOf(
                "Phishing" to "Software update to fix vulnerabilities",
                "Backup" to "Fake emails designed to steal information",
                "Patch" to "Copies of data stored separately"
            ),
            correctAnswer = mapOf(
                "Phishing" to "Fake emails designed to steal information",
                "Backup" to "Copies of data stored separately",
                "Patch" to "Software update to fix vulnerabilities"
            ),
            reward = 20
        ), Question.TrueOrFalse(
            question = "You should disable automatic updates to prevent disruptions from ransomware.", correctAnswer = false, reward = 5
        ), Question.MultipleAnswer(
            question = "What are the benefits of using a password manager? (Select all that apply)", options = listOf("Storing complex passwords", "Automatically filling passwords", "Using the same password for all sites", "Generating random strong passwords"), correctAnswers = listOf("Storing complex passwords", "Automatically filling passwords", "Generating random strong passwords"), reward = 20
        ), Question.InteractiveQuiz(
            question = "Why should you avoid using public Wi-Fi for sensitive transactions?", options = listOf("It’s slower", "It’s less secure", "It costs money", "It’s less convenient"), correctAnswer = "It’s less secure", reward = 10
        ), Question.Matching(
            instruction = "",
            pairs = mapOf(
                "Firewalls" to "Ensures data recovery",
                "Two-factor authentication" to "Requires two forms of identification",
                "Regular backups" to "Monitors and controls network traffic"
            ),
            correctAnswer = mapOf(
                "Firewalls" to "Monitors and controls network traffic",
                "Regular backups" to "Ensures data recovery",
                "Two-factor authentication" to "Requires two forms of identification"
            ),
            reward = 20
        ), Question.Visual(
            imageUrl = listOf(R.drawable.level_4_question_9_a, R.drawable.level_4_question_9_b), question = "Select the icon that represents a secure connection (HTTPS).", options = listOf("A", "B"), correctAnswer = "B", reward = 10
        )
    )

    val level5Questions = listOf(
        Question.MultipleChoice(
            question = "Which action is NOT recommended if you suspect a ransomware attack?", options = listOf("Disconnecting from the internet", "Paying the ransom", "Contacting IT support", "Reporting the attack"), correctAnswer = "Paying the ransom", reward = 10
        ), Question.TrueOrFalse(
            question = "Ransomware can be spread through legitimate websites that have been compromised.", correctAnswer = true, reward = 5
        ), Question.ScenarioBased(
            scenario = "After detecting ransomware, your IT team advises using backups to restore data.", question = "What should you ensure before proceeding?", options = listOf("The backups are current and clean", "The ransomware is still active", "The ransom is paid", "The affected files are deleted"), correctAnswer = "The backups are current and clean", reward = 15
        ), Question.FillInTheBlank(
            question = "Always verify the __________ of an email before downloading attachments or clicking links.", correctAnswer = "Sender", reward = 10
        ), Question.Matching(
            instruction = "",
            pairs = mapOf(
                "Firewall" to "Protects against malicious software", "Anti-Malware" to "Converts data into a secure format", "Encryption" to "Monitors and filters incoming and outgoing network traffic"
            ),
            correctAnswer = mapOf(
                "Firewall" to "Monitors and filters incoming and outgoing network traffic",
                "Anti-Malware" to "Protects against malicious software",
                "Encryption" to "Converts data into a secure format"
            ),
            reward = 20
        ), Question.MultipleAnswer(
            question = "Which practices can help secure your network against ransomware? (Select all that apply)", options = listOf("Using a strong firewall", "Disabling security features", "Regularly updating software", "Conducting security training"), correctAnswers = listOf("Using a strong firewall", "Regularly updating software", "Conducting security training"), reward = 10
        ), Question.InteractiveQuiz(
            question = "What should be included in a ransomware response plan?", options = listOf("Steps for disconnecting infected systems", "Methods to pay the ransom", "Procedures for reporting the incident", "Strategies for data recovery"), correctAnswer = "Steps for disconnecting infected systems", reward = 10
        ), Question.DragAndDrop(
            question = "Order these actions to protect against ransomware:",
            items = listOf(
                "Enable automatic updates", "Use strong passwords", "Install antivirus software", "Avoid clicking unknown links"
            ), correctOrder = listOf(
                "Enable automatic updates", "Use strong passwords", "Install antivirus software", "Avoid clicking unknown links"
            ), reward = 20
        ), Question.Visual(
            imageUrl = listOf(R.drawable.level_5_question_9), question = "Identify the secure website based on the URL.", options = listOf("Green", "Red"), correctAnswer = "Green", reward = 10
        ), Question.FillInTheBlank(
            question = "A __________ attack involves tricking individuals into revealing confidential information.", correctAnswer = "Social engineering attack", reward = 10
        )
    )

}