CREATE DATABASE knowledge_track CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

CREATE TABLE knowledge_track.dataset (
                                         id INT AUTO_INCREMENT PRIMARY KEY,
                                         name VARCHAR(128) NOT NULL,
                                         description VARCHAR(255),
                                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                         updated_at TIMESTAMP null,
                                         deleted_at TIMESTAMP null
) DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci;







CREATE TABLE knowledge_track.knowledge_data (
                                                id INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
                                                dataset_id INT COMMENT '所属数据集id',
                                                group_name varchar(255) comment '分组名称',
                                                title VARCHAR(255) NOT NULL comment '知识点标题',
                                                content text comment '知识点详情',
                                                difficulty int comment '知识点难度',
                                                master_level int comment '掌握程度',
                                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP comment '创建时间',
                                                updated_at TIMESTAMP null comment '更新时间',
                                                deleted_at TIMESTAMP null comment '删除时间'
) DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci;


select * from dataset;