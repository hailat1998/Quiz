package com.hd.quiz

import com.hd.quiz.api.Question

val list = mutableListOf<Question>(Question("122dfdsfdfgfdg13", "T/f", "The Great Wall of China can be seen from space.", null, null, null, null,
    "Student", "Science", answer="False"),Question("122adfvzdfsdfd13", "T/f", "The human body has 206 bones.", null, null, null, null,
    "Student", "Science", answer="True"),Question("12zdbvcergsdf213", "T/f", "The Nile River is the longest river in the world.", null,
    null, null, null, "Student", "Science", answer="True"),
    Question("1221vcvlkadmfld3", "T/f", "The Statue of Liberty was a gift from France to the United States.", null, null, null, null,
        "Student", "Science", answer="True"),
    Question("122kjscnvsaid13", "T/f", "The sun is a planet.", null, null, null, null, "Student",
        "Science", answer="False"),
    Question("122jdsnvsjdvnsojdv13", "T/f", "The capital of Australia is Sydney.", null, null, null, null, "Student",
        "Science", answer="False"),
    Question("1dkvnsdjnvsd2213", "T/f", "The speed of sound is faster than the speed oflight.", null, null,
        null, null, "Student", "Science", answer="False"),
    Question("12sjdnvsijnsidf213", "T/f", "Diamonds are made from compressed coal.", null, null, null, null, "Student",
        "Science", answer="False"),
    Question("12zdkfnvmskjvnsd213", "fill", "The capital of France is ", null, null, null, null,
        "Student", "Social", answer="Paris"),
    Question("12skjncsidjfsd213", "fill", "The largest ocean in the world is the ", null, null, null, null, "Student", "Social", "Pacific"),
    Question("12skjvnxbvskvd213", "fill", "The author of Harry Potter is ", null, null, null, null, "Student", "Social", "Rowling"),
            Question("12213", "fill", "The most populous country in the world is", null, null, null, null, "Student", "Social", "China"),
    Question(
        "12213", "Choice", "Which of the following activities is commonly associated with relaxation and stress relief?", "Mountain Climbing", "Yoga",
        "Video Gaming", "Bungee Jumping", "Adult", "Social", "Yoga"
    ),Question(
        "f92e7f5c-b47b-4b3e-8e84-2e916f059a9c", "Choice", "Which of the following activities is commonly associated with physical exertion and adventure?", "Hiking", "Photography",
        "Chess", "Swimming", "Worker", "Social", "Hiking"
    ),Question(
        "b36e41f9-6400-4e81-8c47-5e3e4c8f7d0d", "Choice", "Which of the following subjects involves the study of past events?", "Mathematics", "Biology", "Geography",
        "Chemistry", "Student", "History", "History"
    ),
    Question("9a3f81a3-5e1b-4e6b-ae8d-244d0b011d6c", "Choice", "Which of the following activities is commonly associated with relaxation and stress relief?", "Yoga", "Meditation", "Reading", "Painting", "Adult", "Social", "Yoga"),

    Question("c1c2b0c3-31a0-4e31-ba0e-3e7a1e8f2b5e", "Choice", "Which of the following activities is commonly associated with innovation and experimentation?", "Science Fair Projects", "Basket Weaving", "Running", "Knitting", "Student", "Science", "Science Fair Projects"),

    Question("d8e9f7a2-4e6d-4f2a-bf7c-3a2a4b9c1d8e", "Choice", "Which of the following subjects involves the study of natural phenomena and the physical world?", "Physics", "Literature", "Psychology", "Music", "Adult", "Science", "Physics"),

    Question("9e3d6f63-2e7b-4f5b-a7c6-b2a1c3d9e8f7", "Choice", "Which of the following activities is commonly associated with teamwork and collaboration?", "Group Projects", "Solo Singing", "Individual Writing", "Sculpting", "Student", "Social", "Group Projects"),
    Question("7d5e2c4e-9a8b-4c6d-9e8f-1a2b3c4d5e6f", "Choice", "Which of the following subjects involves the study of the Earth and its features?", "Geography", "Economics", "Apologies for the inconvenience.", "", "Worker", "History", "Geography"),

    Question("d4b2f3a5-6c7a-4e8a-b9c9-1d2e3f4a5b6c", "Choice", "Which of the following activities is commonly associated with relaxation and stress relief?", "Mountain Climbing", "Yoga", "Video Gaming", "Bungee Jumping", "Adult", "Social", "Yoga"),

    Question("e5f6d7c8-9a1b-4c2d-8e3f-0a1b2c3d4e5f", "Choice", "Which of the following activities is commonly associated with physical exertion and adventure?", "Hiking", "Photography", "Chess", "Swimming", "Worker", "Social", "Hiking"),

    Question("a1b2c3d4-e5f6-4g7h-8i9j-k0l1m2n3o4p", "Choice", "Which of the following activities is commonly associated with problem-solving and critical thinking?", "Programming", "Singing", "Dancing", "Cooking", "Worker", "Science", "Programming"),

    Question("q1w2e3r4-t5y6-4u7i-8o9p-0a1s2d3f4g5h", "Choice", "Which of the following subjects involves the study of past events?", "Mathematics", "Biology", "Geography", "Chemistry", "Student", "History", "History"),

    Question("j1k2l3m4n5-o6p7-4q8w-9e0r-1t2y3u4i5o6p", "Choice", "Which of the following activities is commonly associated with relaxation and stress relief?", "Yoga", "Meditation", "Reading", "Painting", "Adult", "Social", "Yoga"),

    Question("a2s3d4f5g6-h7j8-4k9l-0z1x-2c3v4b5n6m7", "Choice", "Which of the following activities is commonly associated with innovation and experimentation?", "Science Fair Projects", "Basket Weaving", "Running", "Knitting", "Student", "Science", "Science Fair Projects"),

    Question("q9w8e7r6t5-y4u3-4i2o-1p0a-9s8d7f6g5h4", "Choice", "Which of the following subjects involves the study of natural phenomena and the physical world?", "Physics", "Literature", "Psychology", "Music", "Adult", "Science", "Physics"),
    Question(
        "j8h7g6f5d4-s3a2-4d5f-6g7h-8j9k0l1m2n3",
        "Choice",
        "Which of the following activities is commonly associated with teamwork and collaboration?",
        "Group Projects", "Solo Singing", "Individual Writing", "Sculpting",
        "Student",
        "Social",
        "Group Projects"
    )
    ,
    Question(
        "a5a3dfb4-2f60-4e2c-8c36-dc0e3b6e5f0d",
        "Choice",
        "Which of the following activities is commonly associated with problem-solving and logical thinking?",
        "Programming", "Gardening", "Photography", "Knitting",
        "Worker",
        "Science",
        "Programming"
    )
    ,
    Question(
        "f45f576f-7d7b-4cac-bd40-6f3b5e6a1f7c",
        "Choice",
        "Which of the following activities is commonly associated with social interaction and communication?",
        "Networking Events", "Solo Reading", "Individual Sports", "Pottery Making",
        "Worker",
        "Social",
        "Networking Events"
    )
    ,
    Question(
        "b8c1e6e2-13ab-4a5c-9d70-4a52c2e83269",
        "T/F",
        "Yoga is commonly associated with relaxation and stress relief.",
        null,
        null,
        null,
        null,
        "Adult",
        "Social",
        "true"
    )
    ,
    Question(
        "1d5e7a2a-76c0-4cfa-9e6f-3c88d5e6b3d0",
        "T/F",
        "History involves the study of past events.",
        null,
        null,
        null,
        null,
        "Student",
        "History",
        "true"
    )
    ,
    Question(
        "a9c3e0d0-4f68-496d-9e81-0c2a7e3e7c47",
        "T/F",
        "Programming is commonly associated with problem-solving and critical thinking.",
        null,
        null,
        null,
        null,
        "Worker",
        "Science",
        "true"
    )
    ,
    Question(
        "e4e0c0e2-2e74-4c9f-9b44-1e7d4a6d5f3a",
        "T/F",
        "Hiking is commonly associated with physical exertion and adventure.",
        null,
        null,
        null,
        null,
        "Worker",
        "Social",
        "true"
    )
    ,
    Question(
        "7c6b7a29-10a7-4f4c-8a12-8a2b90b6c32d",
        "T/F",
        "Science Fair Projects involve innovation and experimentation.",
        null,
        null,
        null,
        null,
        "Student",
        "Science",
        "true"
    )
    ,
    Question(
        "b2d9b4e1-2f0e-4df2-9c75-2a0e1c6d7b8a",
        "T/F",
        "Physics involves the study of natural phenomena and the physical world.",
        null,
        null,
        null,
        null,
        "Adult",
        "Science",
        "true"
    )
    ,
    Question(
        "3e5c8a0f-6c92-4c9b-8f1c-f8b7e4e9f0a0",
        "T/F",
        "Group Projects commonly involve teamwork and collaboration.",
        null,
        null,
        null,
        null,
        "Student",
        "Social",
        "true"
    )
    ,
    Question(
        "f3b2d8a4-ae3c-4b1a-9f8b-6c4d2a1b3e7f",
        "T/F",
        "Geography involves the study of the Earth and its features.",
        null,
        null,
        null,
        null,
        "Worker",
        "History",
        "true"
    )
    ,
    Question(
        "0d1c8e2a-7d91-4a22-92ee-3e7a5b6d1c4f",
        "T/F",
        "Painting is commonly associated with artistic expression and creativity.",
        null,
        null,
        null,
        null,
        "Adult",
        "Social",
        "true"
    )
    ,
    Question(
        "j8h7g6f5d4-s3a2-4d5f-6g7h-8j9k0l1m2n3",
        "Choice",
        "Which of the following activities is commonly associated with teamwork and collaboration?",
        "Group Projects",
        "Solo Singing",
        "Individual Writing",
        "Sculpting",
        "Student",
        "Social",
        "Group Projects"
    )
    ,
    Question(
        "a5a3dfb4-2f60-4e2c-8c36-dc0e3b6e5f0d",
        "Choice",
        "Which of the following activities is commonly associated with problem-solving and logical thinking?",
        "Programming",
        "Gardening",
        "Photography",
        "Knitting",
        "Worker",
        "Science",
        "Programming"
    )
    ,
    Question(
        "f45f576f-7d7b-4cac-bd40-6f3b5e6a1f7c",
        "Choice",
        "Which of the following activities is commonly associated with social interaction and communication?",
        "Networking Events",
        "Solo Reading",
        "Individual Sports",
        "Pottery Making",
        "Worker",
        "Social",
        "Networking Events"
    )
    ,
    Question(
        "b8c1e6e2-13ab-4a5c-9d70-4a52c2e83269",
        "T/F",
        "Yoga is commonly associated with relaxation and stress relief.",
        null,
        null,
        null,
        null,
        "Adult",
        "Social",
        "true"
    )
    ,
    Question(
        "1d5e7a2a-76c0-4cfa-9e6f-3c88d5e6b3d0",
        "T/F",
        "History involves the study of past events.",
        null,
        null,
        null,
        null,
        "Student",
        "History",
        "true"
    )
    ,
    Question(
        "a9c3e0d0-4f68-496d-9e81-0c2a7e3e7c47",
        "T/F",
        "Programming is commonly associated with problem-solving and critical thinking.",
        null,
        null,
        null,
        null,
        "Worker",
        "Science",
        "true"
    )
    ,
    Question(
        "e4e0c0e2-2e74-4c9f-9b44-1e7d4a6d5f3a",
        "T/F",
        "Hiking is commonly associated with physical exertion and adventure.",
        null,
        null,
        null,
        null,
        "Worker",
        "Social",
        "true"
    )
    ,
    Question(
        "7c6b7a29-10a7-4f4c-8a12-8a2b90b6c32d",
        "T/F",
        "Science Fair Projects involve innovation and experimentation.",
        null,
        null,
        null,
        null,
        "Student",
        "Science",
        "true"
    )
    ,
    Question(
        "b2d9b4e1-2f0e-4df2-9c75-2a0e1c6d7b8a",
        "T/F",
        "Physics involves the study of natural phenomena and the physical world.",
        null,
        null,
        null,
        null,
        "Adult",
        "Science",
        "true"
    )
    ,
    Question(
        "3e5c8a0f-6c92-4c9b-8f1c-f8b7e4e9f0a0",
        "T/F",
        "Group Projects commonly involve teamwork and collaboration.",
        null,
        null,
        null,
        null,
        "Student",
        "Social",
        "true"
    )
    ,
    Question(
        "f3b2d8a4-ae3c-4b1a-9f8b-6c4d2a1b3e7f",
        "T/F",
        "Geography involves the study of the Earth and its features.",
        null,
        null,
        null,
        null,
        "Worker",
        "History",
        "true"
    )
    ,
    Question(
        "0d1c8e2a-7d91-4a22-92ee-3e7a5b6d1c4f",
        "T/F",
        "Painting is commonly associated with artistic expression and creativity.",
        null,
        null,
        null,
        null,
        "Adult",
        "Social",
        "true"
    ),
    Question(
        "9d5c14a7-e1f2-4c38-89f1-ee9c9f1e8c7d",
        "T/F",
        "Biology involves the study of living organisms.",
        null,
        null,
        null,
        null,
        "Science",
        "Student",
        "true"
    )
    ,
    Question(
        "e1c4b920-1e48-4a88-bef9-1f60c07e1f9d",
        "T/F",
        "Programming is commonly associated with problem-solving and logical thinking.",
        null,
        null,
        null,
        null,
        "Science",
        "Worker",
        "true"
    )
    ,
    Question(
        "f5e1d4e5-3e7c-4b90-9d6f-6a3b8c7f2d9a",
        "T/F",
        "Networking Events commonly involve social interaction and communication.",
        null,
        null,
        null,
        null,
        "Social",
        "Worker",
        "true"
    )
    ,
    Question(
        "8b9c1d4e-e7f2-4a6d-9c8b-0e1f3a4b5c6d",
        "Fill",
        "______ is commonly associated with relaxation and stress relief.",
        null,
        null,
        null,
        null,
        "Social",
        "Adult",
        "Meditation"
    )
    ,
    Question(
        "2a3b4c5d-6e7f-8a9b-c1d2e3f4a5b6",
        "Fill",
        "______ involves the study of past events.",
        null,
        null,
        null,
        null,
        "History",
        "Student",
        "History"
    )
    ,
    Question(
        "1a2b3c4d-5e6f-7a8b-9c0d1e2f3a4b",
        "Fill",
        "______ is commonly associated with problem-solving and critical thinking.",
        null,
        null,
        null,
        null,
        "Science",
        "Worker",
        "Science"
    )
    ,
    Question(
        "0e1f2a3b-4c5d-6e7f-8a9b-c0d1e2f3a4b",
        "Fill",
        "______ is commonly associated with physical exertion and adventure.",
        null,
        null,
        null,
        null,
        "Social",
        "Worker",
        "Outdoor activities"
    )
    ,
    Question(
        "9c8b7a6f-5e4d-3c2b-1a0d-9e8f7a6b5c4d",
        "Fill",
        "______ involve innovation and experimentation.",
        null,
        null,
        null,
        null,
        "Science",
        "Student",
        "Science projects"
    )
    ,
    Question(
        "f2e3d4c5-b6a7-8c9d-0e1f-2a3b4c5d6e7",
        "Fill",
        "______ involves the study of natural phenomena and the physical world.",
        null,
        null,
        null,
        null,
        "Science",
        "Adult",
        "Physics"
    )
    ,
    Question(
        "8a9b0c1d-2e3f-4a5b-6c7d-8e9f0a1b2c3",
        "Fill",
        "______ commonly involve teamwork and collaboration.",
        null,
        null,
        null,
        null,
        "Social",
        "Student",
        "Group projects"
    )
    ,
    Question(
        "4d5e6f7a-8b9c-1d2e-3f4a-5b6c7d8e9f0a",
        "Fill",
        "______ involves the study of the Earth and its features.",
        null,
        null,
        null,
        null,
        "History",
        "Worker",
        "Geography"
    )
    ,
    Question(
        "1b2c3d4e-5f6a-7b8c-9d0e-1f2a3b4c5d6e",
        "Fill",
        "______ is commonly associated with artistic expression and creativity.",
        null,
        null,
        null,
        null,
        "Social",
        "Adult",
        "Art"
    )
    ,
    Question(
        "9d5c14a7-e1f2-4c38-89f1-ee9c9f1e8c7d",
        "T/F",
        "Biology involves the study of living organisms.",
        null,
        null,
        null,
        null,
        "Science",
        "Student",
        "true"
    )
    ,
    Question(
        "e1c4b920-1e48-4a88-bef9-1f60c07e1f9d",
        "T/F",
        "Programming is commonly associated with problem-solving and logical thinking.",
        null,
        null,
        null,
        null,
        "Science",
        "Worker",
        "true"
    )
    ,
    Question(
        "f5e1d4e5-3e7c-4b90-9d6f-6a3b8c7f2d9a",
        "T/F",
        "Networking Events commonly involve social interaction and communication.",
        null,
        null,
        null,
        null,
        "Social",
        "Worker",
        "true"
    )
    ,
    Question(
        "8b9c1d4e-e7f2-4a6d-9c8b-0e1f3a4b5c6d",
        "Fill",
        "______ is commonly associated with relaxation and stress relief.",
        null,
        null,
        null,
        null,
        "Social",
        "Adult",
        "Meditation"
    )
    ,
    Question(
        "2a3b4c5d-6e7f-8a9b-c1d2e3f4a5b6",
        "Fill",
        "______ involves the study of past events.",
        null,
        null,
        null,
        null,
        "History",
        "Student",
        "History"
    )
    ,
    Question(
        "1a2b3c4d-5e6f-7a8b-9c0d1e2f3a4b",
        "Fill",
        "______ is commonly associated with problem-solving and critical thinking.",
        null,
        null,
        null,
        null,
        "Science",
        "Worker",
        "Science"
    )
    ,
    Question(
        "0e1f2a3b-4c5d-6e7f-8a9b-c0d1e2f3a4b",
        "Fill",
        "______ is commonly associated with physical exertion and adventure.",
        null,
        null,
        null,
        null,
        "Social",
        "Worker",
        "Outdoor activities"
    )
    ,
    Question(
        "9c8b7a6f-5e4d-3c2b-1a0d-9e8f7a6b5c4d",
        "Fill",
        "______ involve innovation and experimentation.",
        null,
        null,
        null,
        null,
        "Science",
        "Student",
        "Science projects"
    )
    ,
    Question(
        "f2e3d4c5-b6a7-8c9d-0e1f-2a3b4c5d6e7",
        "Fill",
        "______ involves the study of natural phenomena and the physical world.",
        null,
        null,
        null,
        null,
        "Science",
        "Adult",
        "Physics"
    )
    ,
    Question(
        "8a9b0c1d-2e3f-4a5b-6c7d-8e9f0a1b2c3",
        "Fill",
        "______ commonly involve teamwork and collaboration.",
        null,
        null,
        null,
        null,
        "Social",
        "Student",
        "Group projects"
    )
    ,
    Question(
        "4d5e6f7a-8b9c-1d2e-3f4a-5b6c7d8e9f0a",
        "Fill",
        "______ involves the study of the Earth and its features.",
        null,
        null,
        null,
        null,
        "History",
        "Worker",
        "Geography"
    )
    ,
    Question(
        "1b2c3d4e-5f6a-7b8c-9d0e-1f2a3b4c5d6e",
        "Fill",
        "______ is commonly associated with artistic expression and creativity.",
        null,
        null,
        null,
        null,
        "Social",
        "Adult",
        "Art"
    ))