// src/Pages/KnowledgeData.jsx
import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { Table, Button, Popconfirm, Rate, message, Form, Input, Select, Space, Row, Col } from 'antd';
import { StarOutlined, HeartOutlined } from '@ant-design/icons';
import knowledgeApi from '../api/KnowledgeDataApi';
import moment from 'moment';


const { Option } = Select;

const KnowledgeData = () => {
  const { datasetId } = useParams();
  const [KnowledgeData, setKnowledgeData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [pagination, setPagination] = useState({
    current: 1,
    pageSize: 10,
    total: 0,
  });

  const [formValues, setFormValues] = useState({
    groupName: '',
    difficulty: '',
    masterLevel: '',
    search: '',
  });

  const [groupOptions, setGroupOptions] = useState([]);


  // 表格处理代码

  const loadKnowledgeData = async (pageNum, pageSize) => {
    setLoading(true);
    const params = {
      pageNum: pageNum,
      pageSize: pageSize,
      datasetId : datasetId
    };
    knowledgeApi.list(params).then(res => {
      if (res.data.code === 0) {
        setKnowledgeData(res.data.data.list);
        setPagination({
          ...pagination,
          current: pageNum,
          pageSize: pageSize,
          total: res.data.data.total,
        });
      } else {
        console.log(res.data.message);
      }
    });
    setLoading(false);
  };

  useEffect(() => {
    loadKnowledgeData(pagination.current, pagination.pageSize);
  }, [datasetId, pagination.current, pagination.pageSize]);

  const handleTableChange = (newPagination) => {
    setPagination(newPagination);
    loadKnowledgeData(newPagination.current, newPagination.pageSize);
  };


  const handleRateChange = (value, record, field) => {
    const updatedRecord = {
      ...record,
      [field]: value,
    };
    console.log(updatedRecord);
    knowledgeApi.update(updatedRecord).then(res => {
      if (res.data.code === 0) {
        message.success('更新成功');
        loadKnowledgeData(pagination.current, pagination.pageSize);
      } else {
        message.error(res.data.message);
      }
    });
  };

  const handleDelete = (id) => {
    knowledgeApi.delete(id).then(res => {
      if (res.data.code === 0) {
        message.success('删除成功');
        loadKnowledgeData(pagination.current, pagination.pageSize);
      } else {
        message.error(res.data.message);
      }
    });
  };

  // 表单处理代码

  const fetchGroupOptions = () => {
    if (groupOptions.length === 0) {
      knowledgeApi.getGroupNames().then(res => {
        if (res.data.code === 0) {
          setGroupOptions(res.data.data.map(group => ({ label: group.name, value: group.id })));
        } else {
          console.log(res.data.message);
        }
      });
    }
  };

  const handleFormChange = (e) => {
    const { name, value } = e.target;
    setFormValues({
      ...formValues,
      [name]: value,
    });
  };

  const handleSelectChange = (value, name) => {
    setFormValues({
      ...formValues,
      [name]: value,
    });
  };

  const handleSearch = () => {
    const params = {
      ...formValues,
      pageNum: 1,
      pageSize: pagination.pageSize,
      datasetId: datasetId,
    };
    loadKnowledgeData(params.pageNum, params.pageSize, params);
  };

  const handleReset = () => {
    setFormValues({
      groupName: '',
      difficulty: '',
      masterLevel: '',
      search: '',
    });
    loadKnowledgeData(1, pagination.pageSize);
  };




  const columns = [
    {
      title: 'ID',
      dataIndex: 'id',
      key: 'id',
    },
    {
      title: '分组',
      dataIndex: 'groupName',
      key: 'group_name',
    },
    {
      title: '标题',
      dataIndex: 'title',
      key: 'title',
    },
    {
      title: '难度',
      dataIndex: 'difficulty',
      key: 'difficulty',
      render: (difficulty, record) => (
        <Rate
          count={3}
          value={difficulty}
          onChange={(value) => handleRateChange(value, record, 'difficulty')}
        />
      ),
    },
    {
      title: '掌握程度',
      dataIndex: 'masterLevel',
      key: 'master_level',
      render: (masterLevel, record) => (
        <Rate
          character={<HeartOutlined />}
          count={3}
          value={masterLevel}
          onChange={(value) => handleRateChange(value, record, 'masterLevel')}
        />
      ),
    },
    {
      title: '创建时间',
      dataIndex: 'createdAt',
      key: 'created_at',
      render: (createdAt) => createdAt ? moment(createdAt).format('YYYY-MM-DD HH:mm:ss') : '',
    },
    {
      title: '更新时间',
      dataIndex: 'updatedAt',
      key: 'updated_at',
      render: (updatedAt) => updatedAt ? moment(updatedAt).format('YYYY-MM-DD HH:mm:ss') : '',
    },
    {
      title: '操作',
      key: 'action',
      render: (_, record) => (
        <span>
          <Button type="link" onClick={() => handleEdit(record)}>编辑</Button>
          <Popconfirm
            title="确定要删除这条记录吗？"
            onConfirm={() => handleDelete(record.id)}
            okText="确定"
            cancelText="取消"
          >
            <Button type="link">删除</Button>
          </Popconfirm>
        </span>
      )
    }
  ];

  return (
    <div style={{ padding: 24, maxWidth: '80%', margin: '0 auto' }}>
      <Form>
        <Row gutter={16}>
          <Col span={8}>
            <Form.Item label="分组">
              <Select
                name="groupName"
                value={formValues.groupName}
                onChange={(value) => handleSelectChange(value, 'groupName')}
                style={{ width: '100%' }}
                allowClear
                onDropdownVisibleChange={fetchGroupOptions}
              >
                {groupOptions.map(option => (
                  <Option key={option.value} value={option.value}>
                    {option.label}
                  </Option>
                ))}
              </Select>
            </Form.Item>
          </Col>
          <Col span={8}>
            <Form.Item label="难度">
              <Select
                name="difficulty"
                value={formValues.difficulty}
                onChange={(value) => handleSelectChange(value, 'difficulty')}
                style={{ width: '100%' }}
                allowClear
              >
                <Option value="">无</Option>
                <Option value="1">1星</Option>
                <Option value="2">2星</Option>
                <Option value="3">3星</Option>
              </Select>
            </Form.Item>
          </Col>
          <Col span={8}>
            <Form.Item label="掌握程度">
              <Select
                name="masterLevel"
                value={formValues.masterLevel}
                onChange={(value) => handleSelectChange(value, 'masterLevel')}
                style={{ width: '100%' }}
                allowClear
              >
                <Option value="">无</Option>
                <Option value="1">1</Option>
                <Option value="2">2</Option>
                <Option value="3">3</Option>
              </Select>
            </Form.Item>
          </Col>
        </Row>
        <Row gutter={16}>
          <Col span={10}>
            <Form.Item label="搜索">
              <Input
                name="search"
                value={formValues.search}
                onChange={handleFormChange}
                style={{ width: '100%' }}
                placeholder="请输入搜索内容"
              />
            </Form.Item>
          </Col>
          <Col span={14} style={{textAlign: 'right'}}>
            <Form.Item>
              <Space>
                <Button type="primary" onClick={handleSearch}>查询</Button>
                <Button onClick={handleReset}>重置</Button>
              </Space>
            </Form.Item>
          </Col>
        </Row>
      </Form>
      <Table
        columns={columns}
        dataSource={KnowledgeData}
        loading={loading}
        pagination={pagination}
        onChange={handleTableChange}
        rowKey="id"
      />
    </div>
  );
};

export default KnowledgeData;