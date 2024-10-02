package com.j0t1m4.teensecure.data.contents

import com.j0t1m4.teensecure.R

object TeenSecureQuestionLists {

    // Topic: Phishing
    // Level 1: Basic Awareness (Beginner)
    val phishingLevel1Questions = listOf(
        Question.MultipleChoice(
            question = "What is phishing?",
            options = listOf(
                "A cyberattack that steals personal information by tricking you",
                "A method of improving website performance",
                "A way to enhance email security",
                "A technique to increase social media followers"
            ),
            correctAnswer = "A cyberattack that steals personal information by tricking you", reward = 10
        ),
        Question.ScenarioBased(
            scenario = "Emily receives an email from her bank asking her to verify her account by entering her password.",
            question = "What should she do?",
            options = listOf(
                "Enter her password as requested",
                "Verify the email by contacting her bank directly",
                "Share the email with her friends",
                "Ignore the email"
            ),
            correctAnswer = "Verify the email by contacting her bank directly", reward = 15
        ),
        Question.TrueOrFalse(
            question = "Phishing attacks often use fake websites that look like real ones to trick you into giving away personal information.",
            correctAnswer = true, reward = 10
        ),
        Question.TrueOrFalse(
            question = "Phishing only occurs through emails.",
            correctAnswer = false, reward = 10
        ),
        Question.Matching(
            instruction = "Match the phishing method with its description:",
            pairs = mapOf(
                "Email Phishing" to "Uses messages to trick you into giving away information",
                "Message Phishing" to "Pretends to be a trusted website to steal your information",
                "Fake Website" to "Uses emails to trick you into giving away personal information"
            ),
            correctAnswer = mapOf(
                "Email Phishing" to "Uses emails to trick you into giving away personal information",
                "Message Phishing" to "Uses messages to trick you into giving away information",
                "Fake Website" to "Pretends to be a trusted website to steal your information"
            ),
            reward = 20
        ),
        Question.Visual(
            imageUrl = listOf(R.drawable.fake_website, R.drawable.real_website),
            options = listOf("Image A", "Image B"),
            question = "Look at the two images below. One is a real website, and one is a fake website designed for phishing. Identify the fake website.",
            correctAnswer = "Image B", reward = 15
        ),
        Question.MultipleAnswer(
            question = "Which of the following are common signs of a phishing attack? (Select all that apply)",
            options = listOf(
                "Unexpected requests for personal information",
                "Poor grammar and spelling in the message",
                "A sense of urgency or threats",
                "Messages from unknown senders",
                "Offers of free rewards or gifts"
            ),
            correctAnswers = listOf(
                "Unexpected requests for personal information",
                "Poor grammar and spelling in the message",
                "A sense of urgency or threats",
                "Messages from unknown senders",
                "Offers of free rewards or gifts"
            ), reward = 20
        )
    )

    // Level 2: Intermediate Awareness
    val phishingLevel2Questions = listOf(
        Question.MultipleChoice(
            question = "At the intermediate level how do phishing attackers increase the sophistication of their attacks on social media?",
            options = listOf(
                "By using simple generic messages",
                "By including personal details they’ve gathered from other sources",
                "By sending messages through SMS only",
                "By improving the security of social media platforms"
            ),
            correctAnswer = "By including personal details they’ve gathered from other sources", reward = 10
        ),
        Question.ScenarioBased(
            scenario = "Sarah receives a direct message on Facebook from someone she doesn’t know, but the message includes her full name and mentions details about her recent vacation.",
            question = "What should Sarah do?",
            options = listOf(
                "Click the link and log in to view the photos",
                "Reply to the message asking for more information",
                "Verify the legitimacy of the message by checking the sender's profile and contacting Facebook support",
                "Ignore the message"
            ),
            correctAnswer = "Verify the legitimacy of the message by checking the sender's profile and contacting Facebook support", reward = 15
        ),
        Question.TrueOrFalse(
            question = "Phishing attackers can create fake websites that look almost identical to real ones to capture your login information.",
            correctAnswer = true, reward = 10
        ),
        Question.TrueOrFalse(
            question = "At the intermediate level, phishing messages often include personal details to make them more convincing.",
            correctAnswer = true, reward = 10
        ),
        Question.Matching(
            instruction = "Match the phishing tactic with its description at the intermediate level.",
            pairs = mapOf(
                "Personalized Phishing" to "Uses fake websites that look almost identical to real ones",
                "Clone Websites" to "Targets specific individuals with detailed personal information",
                "Spear Phishing" to "Includes personal details in messages to make them more convincing"
            ),
            correctAnswer = mapOf(
                "Personalized Phishing" to "Includes personal details in messages to make them more convincing",
                "Clone Websites" to "Uses fake websites that look almost identical to real ones",
                "Spear Phishing" to "Targets specific individuals with detailed personal information"
            ),
            reward = 20
        ),
        Question.Visual(
            imageUrl = listOf(R.drawable.fb_login_phishing_intermediate, R.drawable.fb_original_login),
            question = "Look at the two login pages below. One is a real login page, and one is a fake page designed for phishing. Identify the fake page.",
            options = listOf("Login Page A", "Login Page B"),
            correctAnswer = "Login Page B", reward = 15
        ),
        Question.MultipleAnswer(
            question = "Which of the following are common characteristics of intermediate-level phishing attacks on social media? (Select all that apply)",
            options = listOf(
                "Use of personal details to make messages more convincing",
                "Creation of fake websites that mimic real ones",
                "Generic messages sent to a large number of users",
                "Direct messages with urgent requests for information",
                "Targeted attacks on specific individuals"
            ),
            correctAnswers = listOf(
                "Use of personal details to make messages more convincing",
                "Creation of fake websites that mimic real ones",
                "Direct messages with urgent requests for information",
                "Targeted attacks on specific individuals"
            ), reward = 20
        )
    )

    // Level 3: Advanced Awareness
    val phishingLevel3Questions = listOf(
        Question.MultipleChoice(
            question = "What is the main characteristic of spear phishing in the context of social media?",
            options = listOf(
                "Sending generic messages to a large number of users",
                "Crafting highly personalized messages using detailed information about the target",
                "Using automated bots to send phishing messages",
                "Creating fake social media accounts to gain followers"
            ),
            correctAnswer = "Crafting highly personalized messages using detailed information about the target", reward = 10
        ),
        Question.ScenarioBased(
            scenario = "John receives a LinkedIn message from someone claiming to be a potential employer mentioning specific details about his job history and projects.",
            question = "What should John do?",
            options = listOf(
                "Log in to the website as requested",
                "Verify the legitimacy of the message by contacting the company directly",
                "Reply to the message with his personal information",
                "Share the message with his friends"
            ),
            correctAnswer = "Verify the legitimacy of the message by contacting the company directly", reward = 15
        ),
        Question.TrueOrFalse(
            question = "Advanced phishing attacks often involve detailed research on the target to craft personalized messages.",
            correctAnswer = true, reward = 10
        ),
        Question.TrueOrFalse(
            question = "Spear phishing attacks on social media are usually random and not targeted.",
            correctAnswer = false, reward = 10
        ),
        Question.Matching(
            instruction = "Match the spear phishing tactic with its description.",
            pairs = mapOf(
                "Social Media Profiling" to "Gathering detailed information about the target from social media and other sources",
                "Personalized Messages" to "Messages crafted using specific details about the target’s job history or interests",
                "Fake Job Offers" to "Creating fake job offers that appear legitimate to the target"
            ),
            correctAnswer = mapOf(
                "Social Media Profiling" to "Gathering detailed information about the target from social media and other sources",
                "Personalized Messages" to "Messages crafted using specific details about the target’s job history or interests",
                "Fake Job Offers" to "Creating fake job offers that appear legitimate to the target"
            ),
            reward = 20
        ),
        Question.Visual(
            imageUrl = listOf(R.drawable.phishin_3_msg_a, R.drawable.phishin_3_msg_b),
            question = "Look at the two messages below. One is a real job offer from a known company, and one is a spear phishing attempt. Identify the phishing message.",
            options = listOf("Message A", "Message B"),
            correctAnswer = "Message A", reward = 15
        ),
        Question.MultipleAnswer(
            question = "Which of the following tactics are commonly used in advanced spear phishing attacks on social media? (Select all that apply)",
            options = listOf(
                "Gathering detailed information about the target from social media",
                "Sending messages with personalized details",
                "Creating fake websites that mimic legitimate ones",
                "Using generic messages with no personal information",
                "Targeting individuals with fake job offers"
            ),
            correctAnswers = listOf(
                "Gathering detailed information about the target from social media",
                "Sending messages with personalized details",
                "Creating fake websites that mimic legitimate ones",
                "Targeting individuals with fake job offers"
            ), reward = 20
        )
    )


    // Topic: Baiting

    // Level 1: Basic Awareness (Beginner)
    val baitingLevel1Questions = listOf(
        Question.MultipleChoice(
            question = "What is baiting in the context of cyberattacks?",
            options = listOf(
                "A technique to increase social media followers",
                "A cyberattack where attackers use false promises to lure you into giving away personal information or infecting your computer with malware",
                "A method of improving computer performance",
                "A way to enhance email security"
            ),
            correctAnswer = "A cyberattack where attackers use false promises to lure you into giving away personal information or infecting your computer with malware", reward = 10
        ),
        Question.ScenarioBased(
            scenario = "Alex receives a message on Twitter with a link to download a free new movie. The message is from someone he doesn’t know.",
            question = "What should Alex do?",
            options = listOf(
                "Click the link to download the movie",
                "Ignore the message and avoid clicking the link",
                "Share the link with his friends",
                "Reply to the message asking for more information"
            ),
            correctAnswer = "Ignore the message and avoid clicking the link", reward = 15
        ),
        Question.TrueOrFalse(
            question = "Baiting attacks often use free music, movies, or software downloads as bait.",
            correctAnswer = true, reward = 10
        ),
        Question.TrueOrFalse(
            question = "Baiting only occurs through emails.",
            correctAnswer = false, reward = 10
        ),
        Question.Matching(
            instruction = "Match the baiting tactics with its description:",
            pairs = mapOf(
                "Free Music Download" to "Offers free access to a popular movie to lure you into downloading malware",
                "Free Movie Download" to "Offers free software to entice you into giving away personal information or downloading malware",
                "Free Software Download" to "Offers free access to music files to lure you into a trap"
            ),
            correctAnswer = mapOf(
                "Free Music Download" to "Offers free access to music files to lure you into a trap",
                "Free Movie Download" to "Offers free access to a popular movie to lure you into downloading malware",
                "Free Software Download" to "Offers free software to entice you into giving away personal information or downloading malware"
            ),
            reward = 20
        ),
        Question.Visual(
            imageUrl = listOf(R.drawable.baiting_q1_link_a, R.drawable.baiting_q1_link_b),
            options = listOf("Link A", "Link B"),
            question = "Look at the two links below. One link offers a legitimate download, and the other is a baiting attempt. Identify the baiting link.",
            correctAnswer = "Link B", reward = 15
        ),
        Question.MultipleAnswer(
            question = "Which of the following are common characteristics of baiting attacks on social media? (Select all that apply)",
            options = listOf(
                "Offers of free downloads",
                "Messages from unknown senders",
                "Links to download music, movies, or software",
                "Requests for personal information",
                "Generic promotional messages"
            ),
            correctAnswers = listOf(
                "Offers of free downloads",
                "Messages from unknown senders",
                "Links to download music, movies, or software",
                "Requests for personal information"
            ), reward = 20
        )
    )

    // Level 2: Intermediate Awareness
    val baitingLevel2Questions = listOf(
        Question.MultipleChoice(
            question = "How do baiting attacks become more convincing at the intermediate level?",
            options = listOf(
                "By using simple generic messages",
                "By appearing as legitimate software updates or important-looking documents",
                "By only targeting emails",
                "By improving the security of social media platforms"
            ),
            correctAnswer = "By appearing as legitimate software updates or important-looking documents", reward = 10
        ),
        Question.ScenarioBased(
            scenario = "Maria sees a post on Facebook from a page she follows offering a free software update that claims to improve her device's performance.",
            question = "What should Maria do?",
            options = listOf(
                "Click the link and download the update",
                "Verify the legitimacy of the post by checking the official website of the software",
                "Share the post with her friends",
                "Ignore the post"
            ),
            correctAnswer = "Verify the legitimacy of the post by checking the official website of the software", reward = 15
        ),
        Question.TrueOrFalse(
            question = "Intermediate-level baiting attacks can be found on trusted websites that have been compromised.",
            correctAnswer = true, reward = 10
        ),
        Question.TrueOrFalse(
            question = "Baiting attacks at this level only occur through social media messages.",
            correctAnswer = false, reward = 10
        ),
        Question.Matching(
            instruction = "Match the baiting tactics with their descriptions at the intermediate level.",
            pairs = mapOf(
                "Fake Software Update" to "Legitimate websites that have been hacked to host malicious downloads",
                "Compromised Trusted Websites" to "Documents that appear important, like invoices or reports, containing malware",
                "Important-looking Documents" to "Updates that seem genuine but are actually malware"
            ), correctAnswer = mapOf(
                "Fake Software Update" to "Updates that seem genuine but are actually malware",
                "Compromised Trusted Websites" to "Legitimate websites that have been hacked to host malicious downloads",
                "Important-looking Documents" to "Documents that appear important like invoices or reports containing malware"
            ),
            reward = 20
        ),
        Question.Visual(
            imageUrl = listOf(R.drawable.baiting_q1_link_a, R.drawable.baiting_q1_link_b),
            question = "Look at the two download links below. One is a legitimate software update, and the other is a baiting attempt. Identify the baiting link.",
            options = listOf("Link A", "Link B"),
            correctAnswer = "Link A", reward = 15
        ),
        Question.MultipleAnswer(
            question = "Which of the following are common characteristics of intermediate-level baiting attacks on social media? (Select all that apply)",
            options = listOf(
                "Offers of legitimate-looking software updates",
                "Posts from trusted websites that have been compromised",
                "Documents that appear important",
                "Generic messages with no personal details",
                "Messages or posts from unknown senders"
            ),
            correctAnswers = listOf(
                "Offers of legitimate-looking software updates",
                "Posts from trusted websites that have been compromised",
                "Documents that appear important",
                "Messages or posts from unknown senders"
            ), reward = 20
        )
    )

    // Level 3: Advanced Awareness
    val baitingLevel3Questions = listOf(
        Question.MultipleChoice(
            question = "What is a key characteristic of advanced baiting attacks?",
            options = listOf(
                "Using simple generic messages",
                "Embedding malware in seemingly harmless files",
                "Only targeting corporate emails",
                "Using low-quality websites for bait"
            ),
            correctAnswer = "Embedding malware in seemingly harmless files", reward = 10
        ),
        Question.ScenarioBased(
            scenario = "Emily receives a direct message on Instagram from a friend containing a link to a document labeled 'Photos from our trip.' The link leads to a website that looks identical to a popular cloud storage service.",
            question = "What should Emily do?",
            options = listOf(
                "Click the link and download the document",
                "Ignore the message",
                "Verify the message by contacting her friend through another communication channel",
                "Share the link with other friends"
            ),
            correctAnswer = "Verify the message by contacting her friend through another communication channel", reward = 15
        ),
        Question.TrueOrFalse(
            question = "Advanced baiting attacks can use fake websites that look identical to real ones.",
            correctAnswer = true, reward = 10
        ),
        Question.TrueOrFalse(
            question = "Advanced baiting attacks rarely use personalized baits.",
            correctAnswer = false, reward = 10
        ),
        Question.Matching(
            instruction = "Match the advanced baiting tactic with its description.",
            pairs = mapOf(
                "Fake Website" to "Uses detailed information about the target to create more convincing baits",
                "Embedded Malware" to "A website that looks identical to a real one to trick users into entering personal information",
                "Personalized Bait" to "Malicious software hidden in files that seem harmless"
            ),
            correctAnswer = mapOf(
                "Fake Website" to "A website that looks identical to a real one to trick users into entering personal information",
                "Embedded Malware" to "Malicious software hidden in files that seem harmless",
                "Personalized Bait" to "Uses detailed information about the target to create more convincing baits"
            ),
            reward = 20
        ),
        Question.Visual(
            imageUrl = listOf(R.drawable.baiting_q3_a, R.drawable.baiting_q3_b),
            question = "Look at the two websites below. One is a real cloud storage site, and the other is a fake site designed for baiting. Identify the fake site.",
            options = listOf("Website A", "Website B"),
            correctAnswer = "Website B", reward = 15
        ),
        Question.MultipleAnswer(
            question = "Which of the following are common characteristics of advanced baiting attacks on social media? (Select all that apply)",
            options = listOf(
                "Using fake websites that look identical to real ones",
                "Embedding malware in seemingly harmless files",
                "Personalized baits based on detailed information about the target",
                "Generic phishing messages",
                "High-quality graphics and professional-looking pages"
            ),
            correctAnswers = listOf(
                "Using fake websites that look identical to real ones",
                "Embedding malware in seemingly harmless files",
                "Personalized baits based on detailed information about the target",
                "High-quality graphics and professional-looking pages"
            ), reward = 20
        )
    )


    // Topic: Impersonation

    // Level 1: Basic Awareness (Beginner)
    val impersonationLevel1Questions = listOf(
        Question.MultipleChoice(
            question = "What is impersonation in the context of cyberattacks?",
            options = listOf(
                "Sending spam messages to multiple users",
                "Pretending to be someone else to gain trust and access personal information",
                "Creating fake reviews for products",
                "Automating social media posts"
            ),
            correctAnswer = "Pretending to be someone else to gain trust and access personal information", reward = 10
        ),
        Question.ScenarioBased(
            scenario = "Sarah receives a friend request on Facebook from someone claiming to be an old school friend. The profile seems genuine with many mutual friends.",
            question = "What should Sarah do?",
            options = listOf(
                "Accept the friend request immediately",
                "Ignore the friend request",
                "Verify the profile by contacting her real friend through another communication method",
                "Share her personal information with the new friend"
            ),
            correctAnswer = "Verify the profile by contacting her real friend through another communication method", reward = 15
        ),
        Question.TrueOrFalse(
            question = "Impersonation attacks can occur through fake social media profiles, emails, or messages.",
            correctAnswer = true, reward = 10
        ),
        Question.TrueOrFalse(
            question = "Impersonation is only used to send spam messages and not to gain access to personal information.",
            correctAnswer = false, reward = 10
        ),
        Question.Matching(
            instruction = "",
            correctAnswer = mapOf(
                "Fake Social Media Profile" to "A profile on social media that mimics someone you know to gain your trust",
                "Fake Email" to "An email that appears to be from a trusted source but is actually from an attacker",
                "Fake Messages" to "Messages that seem to come from a known contact but are actually from an attacker"
            ),
            pairs = mapOf(
                "Fake Social Media Profile" to "An email that appears to be from a trusted source but is actually from an attacker",
                "Fake Email" to "A profile on social media that mimics someone you know to gain your trust",
                "Fake Messages" to "Messages that seem to come from a known contact but are actually from an attacker"
            ), reward = 20
        ),
        Question.Visual(
            imageUrl = listOf(R.drawable.impersonation_profile),
            question = "Look at the two social media profiles below. One is a legitimate profile, and the other is an impersonation attempt. Identify the impersonation profile.",
            options = listOf("Profile A", "Profile B"),
            correctAnswer = "Profile B", reward = 15
        ),
        Question.MultipleAnswer(
            question = "Which of the following are common tactics used in impersonation attacks on social media? (Select all that apply)",
            options = listOf(
                "Creating fake social media profiles that look like someone you know",
                "Sending emails that appear to be from a trusted source",
                "Sending messages that seem to come from a known contact",
                "Using legitimate channels to contact users",
                "Using automated tools to manage social media accounts"
            ),
            correctAnswers = listOf(
                "Creating fake social media profiles that look like someone you know",
                "Sending emails that appear to be from a trusted source",
                "Sending messages that seem to come from a known contact"
            ), reward = 20
        )
    )

    // Level 2: Intermediate Awareness
    val impersonationLevel2Questions = listOf(
        Question.MultipleChoice(
            question = "How do intermediate-level impersonation attacks differ from beginner-level attacks?",
            options = listOf(
                "They use simple messages and basic fake profiles",
                "They involve well-crafted messages and fake profiles that appear very convincing",
                "They only occur through emails",
                "They use random names without much detail"
            ),
            correctAnswer = "They involve well-crafted messages and fake profiles that appear very convincing", reward = 10
        ),
        Question.ScenarioBased(
            scenario = "Laura receives a message on WhatsApp from someone who claims to be her cousin asking for urgent help with a personal issue. The message looks well-crafted and includes personal details.",
            question = "What should Laura do?",
            options = listOf(
                "Immediately send the requested help",
                "Verify the message by contacting her cousin through another method",
                "Share the message with her social media friends",
                "Ignore the message and do nothing"
            ),
            correctAnswer = "Verify the message by contacting her cousin through another method", reward = 15
        ),
        Question.TrueOrFalse(
            question = "Intermediate-level impersonation attacks often involve impersonating friends, family members, or colleagues to gain trust.",
            correctAnswer = true, reward = 10
        ),
        Question.TrueOrFalse(
            question = "Intermediate-level impersonation attacks usually use unconvincing profiles and messages.",
            correctAnswer = false, reward = 10
        ),
        Question.Matching(
            instruction = "Match the following impersonation tactics with their descriptions:",
            pairs = mapOf(
                "Well-Crafted Messages" to "Profiles that are designed to look like real friends or family members",
                "Fake Profiles" to "Messages that are carefully written to seem genuine and trustworthy",
                "Impersonation of Trusted Contacts" to "Attacks where the impersonator pretends to be someone you know, like a friend or colleague"
            ),
            correctAnswer = mapOf(
                "Well-Crafted Messages" to "Messages that are carefully written to seem genuine and trustworthy",
                "Fake Profiles" to "Profiles that are designed to look like real friends or family members",
                "Impersonation of Trusted Contacts" to "Attacks where the impersonator pretends to be someone you know, like a friend or colleague"
            ),
            reward = 20
        ),
        Question.Visual(
            imageUrl = listOf(R.drawable.impersonation_b),
            question = "Look at the two social media profiles below. One is a genuine profile, and the other is a sophisticated impersonation attempt. Identify the impersonation profile.",
            options = listOf("Profile A", "Profile B"),
            correctAnswer = "Profile B", reward = 15
        ),
        Question.MultipleAnswer(
            question = "Which of the following are characteristics of intermediate-level impersonation attacks on social media? (Select all that apply)",
            options = listOf(
                "Well-crafted messages that seem genuine",
                "Fake profiles that closely mimic real friends or family",
                "Impersonation of colleagues or acquaintances",
                "Simple generic messages with no personal details",
                "Profiles with no mutual connections or personal details"
            ),
            correctAnswers = listOf(
                "Well-crafted messages that seem genuine",
                "Fake profiles that closely mimic real friends or family",
                "Impersonation of colleagues or acquaintances"
            ), reward = 20
        )
    )

    // Level 3: Advanced Awareness
    val impersonationLevel3Questions = listOf(
        Question.MultipleChoice(
            question = "What distinguishes advanced impersonation attacks from intermediate-level attacks?",
            options = listOf(
                "Use of random unverified profiles",
                "Simple messages with no personal details",
                "Extensive research on the target to create highly believable personas",
                "Limited use of social media platforms"
            ),
            correctAnswer = "Extensive research on the target to create highly believable personas", reward = 10
        ),
        Question.ScenarioBased(
            scenario = "Alex receives a friend request on Twitter from a profile that looks exactly like his old college friend. The profile includes detailed information from Alex’s social media posts and mutual connections.",
            question = "What should Alex do?",
            options = listOf(
                "Accept the request and start a conversation",
                "Verify the profile by contacting his friend through a different communication method",
                "Ignore the request without any further checks",
                "Share personal information with the new profile"
            ),
            correctAnswer = "Verify the profile by contacting his friend through a different communication method", reward = 15
        ),
        Question.TrueOrFalse(
            question = "Advanced impersonation attacks involve gathering detailed information from multiple sources to create a very believable persona.",
            correctAnswer = true, reward = 10
        ),
        Question.TrueOrFalse(
            question = "Advanced impersonation attacks are easy to spot due to their simplistic nature.",
            correctAnswer = false, reward = 10
        ),
        Question.Matching(
            instruction = "",
            pairs = mapOf(
                "Extensive Research" to "Creating personas that are almost identical to real people to make detection difficult",
                "Highly Believable Personas" to "Using detailed and varied information from different sources to build a convincing profile",
                "Multiple Information Sources" to "Researching the target thoroughly to gather personal and contextual information"
            ),
            correctAnswer = mapOf(
                "Extensive Research" to "Researching the target thoroughly to gather personal and contextual information",
                "Highly Believable Personas" to "Creating personas that are almost identical to real people to make detection difficult",
                "Multiple Information Sources" to "Using detailed and varied information from different sources to build a convincing profile"
            ),
            reward = 20
        ),
        Question.Visual(
            imageUrl = listOf(R.drawable.impersonation_c),
            question = "Look at the two social media profiles below. One is a highly believable impersonation attempt created using extensive research, and the other is a generic profile. Identify the impersonation profile.",
            options = listOf("Profile A", "Profile B"),
            correctAnswer = "Profile A", reward = 15
        ),
        Question.MultipleAnswer(
            question = "Which of the following are characteristics of advanced impersonation attacks on social media? (Select all that apply)",
            options = listOf(
                "Creation of highly believable personas",
                "Extensive research on the target using multiple sources",
                "Use of generic profiles with minimal details",
                "Profiles that include detailed and accurate information about the target",
                "Simple and non-specific messages"
            ),
            correctAnswers = listOf(
                "Creation of highly believable personas",
                "Extensive research on the target using multiple sources",
                "Profiles that include detailed and accurate information about the target"
            ), reward = 20
        )
    )


    // Topic: Cyberbullying

    // Level 1: Basic Awareness (Beginner)
    val cyberbullyingLevel1Questions = listOf(
        Question.MultipleChoice(
            question = "What is cyberbullying?",
            options = listOf(
                "Using the internet to help people",
                "Using the internet to harass, threaten, or embarrass someone",
                "Sending positive messages and compliments",
                "Sharing educational content online"
            ),
            correctAnswer = "Using the internet to harass, threaten, or embarrass someone", reward = 10
        ),
        Question.ScenarioBased(
            scenario = "Liam notices that someone is posting mean comments about his friend on Instagram. The comments include personal details and spread false rumors.",
            question = "What should Liam do?",
            options = listOf(
                "Ignore the comments and do nothing",
                "Join in the conversation with more comments",
                "Report the posts to Instagram and support his friend",
                "Share the comments with others"
            ),
            correctAnswer = "Report the posts to Instagram and support his friend", reward = 15
        ),
        Question.TrueOrFalse(
            question = "Cyberbullying can involve spreading rumors and sharing private information without permission.",
            correctAnswer = true, reward = 10
        ),
        Question.TrueOrFalse(
            question = "Cyberbullying is only about sending mean messages and does not involve sharing private information.",
            correctAnswer = false, reward = 10
        ),
        Question.Matching(
            instruction = "Match the following cyberbullying tactics with their descriptions:",
            pairs = mapOf(
                "Mean Messages" to "Posting false information about someone to damage their reputation",
                "Spreading Rumors" to "Sending hurtful or threatening messages online",
                "Sharing Private Information" to "Revealing someone’s personal details without their consent"
            ),
            correctAnswer = mapOf(
                "Mean Messages" to "Sending hurtful or threatening messages online",
                "Spreading Rumors" to "Posting false information about someone to damage their reputation",
                "Sharing Private Information" to "Revealing someone’s personal details without their consent"
            ),
            reward = 20
        ),
        Question.Visual(
            imageUrl = listOf(R.drawable.cb_3, R.drawable.cb_1),
            question = "Look at the two social media posts below. One is an example of cyberbullying, and the other is a supportive message. Identify the cyberbullying post.",
            options = listOf("Post A", "Post B"),
            correctAnswer = "Post A", reward = 15
        ),
        Question.MultipleAnswer(
            question = "Which of the following are examples of cyberbullying? (Select all that apply)",
            options = listOf(
                "Sending mean messages to someone",
                "Sharing private information about someone without their permission",
                "Posting supportive and encouraging comments",
                "Spreading false rumors about someone online",
                "Using social media to organize a positive event"
            ),
            correctAnswers = listOf(
                "Sending mean messages to someone",
                "Sharing private information about someone without their permission",
                "Spreading false rumors about someone online"
            ), reward = 20
        )
    )

    // Level 2: Intermediate Awareness
    val cyberbullyingLevel2Questions = listOf(
        Question.MultipleChoice(
            question = "How does intermediate-level cyberbullying differ from beginner-level cyberbullying?",
            options = listOf(
                "It involves more positive interactions",
                "It includes group bullying and spreading harmful content across multiple platforms",
                "It uses only direct messages",
                "It focuses on individual insults without coordination"
            ),
            correctAnswer = "It includes group bullying and spreading harmful content across multiple platforms", reward = 10
        ),
        Question.ScenarioBased(
            scenario = "Mia notices that multiple accounts are tagging her in negative posts and spreading false information about her on different social media platforms. The accounts seem to be fake or anonymous.",
            question = "What should Mia do?",
            options = listOf(
                "Ignore the posts and hope they go away",
                "Respond to the posts with more negative comments",
                "Report the accounts and the posts to the social media platforms and seek support from friends",
                "Share the posts with others to expose the bullies"
            ),
            correctAnswer = "Report the accounts and the posts to the social media platforms and seek support from friends", reward = 15
        ),
        Question.TrueOrFalse(
            question = "Intermediate-level cyberbullying often involves using fake accounts to hide the identity of the bullies.",
            correctAnswer = true, reward = 10
        ),
        Question.TrueOrFalse(
            question = "Intermediate-level cyberbullying typically involves single-platform bullying with no group involvement.",
            correctAnswer = false, reward = 10
        ),
        Question.Matching(
            instruction = "Match the following cyberbullying tactics with their descriptions:",
            pairs = mapOf(
                "Group Bullying" to "Coordinated efforts by multiple users to harass a target",
                "Spreading Harmful Content" to "Distributing negative or damaging information about someone across different platforms",
                "Using Fake Accounts" to "Creating fake or anonymous profiles to hide the bully’s identity"
            ),
            correctAnswer = mapOf(
                "Group Bullying" to "Coordinated efforts by multiple users to harass a target",
                "Spreading Harmful Content" to "Distributing negative or damaging information about someone across different platforms",
                "Using Fake Accounts" to "Creating fake or anonymous profiles to hide the bully’s identity"
            ),
            reward = 20
        ),
        Question.Visual(
            imageUrl = listOf(R.drawable.cb_sets),
            question = "Look at the two sets of social media posts below. One set is an example of coordinated cyberbullying, and the other set contains positive interactions. Identify the cyberbullying set.",
            options = listOf("Set A", "Set B"),
            correctAnswer = "Set A", reward = 15
        ),
        Question.MultipleAnswer(
            question = "Which of the following are tactics used in intermediate-level cyberbullying? (Select all that apply)",
            options = listOf(
                "Using fake accounts to hide the bully’s identity",
                "Coordinated attacks by multiple users",
                "Spreading harmful content across different social media platforms",
                "Sharing supportive messages and compliments",
                "Bullying through single-platform direct messages"
            ),
            correctAnswers = listOf(
                "Using fake accounts to hide the bully’s identity",
                "Coordinated attacks by multiple users",
                "Spreading harmful content across different social media platforms"
            ), reward = 20
        )
    )

    // Level 3: Advanced Awareness
    val cyberbullyingLevel3Questions = listOf(
        Question.MultipleChoice(
            question = "What characterizes advanced-level cyberbullying?",
            options = listOf(
                "Single incidents of mean messages",
                "Serious and persistent harassment that causes significant emotional distress",
                "Simple jokes and harmless pranks",
                "Isolated cases of misinformation"
            ),
            correctAnswer = "Serious and persistent harassment that causes significant emotional distress", reward = 10
        ),
        Question.ScenarioBased(
            scenario = "Samantha has been experiencing ongoing harassment online where her personal information is being shared by multiple fake accounts and she feels overwhelmed by the constant attacks.",
            question = "What should Samantha do?",
            options = listOf(
                "Ignore the harassment and avoid online activities",
                "Seek help from mental health professionals and report the harassment to the platforms and authorities",
                "Retaliate by attacking the accounts that are harassing her",
                "Share the private information publicly to expose the bullies"
            ),
            correctAnswer = "Seek help from mental health professionals and report the harassment to the platforms and authorities", reward = 15
        ),
        Question.TrueOrFalse(
            question = "Advanced cyberbullying can include doxxing, which involves publishing private information about the victim.",
            correctAnswer = true, reward = 10
        ),
        Question.TrueOrFalse(
            question = "Advanced cyberbullying typically involves minor, occasional insults without causing significant emotional harm.",
            correctAnswer = false, reward = 10
        ),
        Question.Matching(
            instruction = "Match the advanced cyberbullying tactic with its description.",
            pairs = mapOf(
                "Persistent Harassment" to "Repeatedly targeting the victim with severe and ongoing harassment",
                "Doxxing" to "Publishing private information about the victim to harm their reputation",
                "Coordinated Attacks from Fake Accounts" to "Using multiple fake accounts to carry out a synchronized attack"
            ),
            correctAnswer = mapOf(
                "Persistent Harassment" to "Repeatedly targeting the victim with severe and ongoing harassment",
                "Doxxing" to "Publishing private information about the victim to harm their reputation",
                "Coordinated Attacks from Fake Accounts" to "Using multiple fake accounts to carry out a synchronized attack"
            ),
            reward = 20
        ),
        Question.Visual(
            imageUrl = listOf(R.drawable.cb_example),
            question = "Look at the two examples of online harassment below. One example is indicative of advanced cyberbullying, and the other is less severe. Identify the advanced cyberbullying example.",
            options = listOf("Example A", "Example B"),
            correctAnswer = "Example A", reward = 15
        ),
        Question.MultipleAnswer(
            question = "Which of the following are characteristics of advanced cyberbullying? (Select all that apply)",
            options = listOf(
                "Serious and persistent harassment causing significant emotional distress",
                "Doxxing or publishing private information about the victim",
                "Coordinated attacks from multiple fake accounts",
                "Casual occasional teasing",
                "Positive supportive interactions"
            ),
            correctAnswers = listOf(
                "Serious and persistent harassment causing significant emotional distress",
                "Doxxing or publishing private information about the victim",
                "Coordinated attacks from multiple fake accounts"
            ), reward = 20
        )
    )
}
