import React, { useState, useEffect } from 'react';
import { Card, List, Pagination } from 'antd';
import { Link, useNavigate } from 'react-router-dom';
import datasetApi from '../api/DatasetApi';

const DatasetList = () => {
  const [dataSets, setDataSets] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [pageSize, setPageSize] = useState(3);
  // const pageSize = 5;
  const [total, setTotal] = useState(0);
  const navigate = useNavigate();


  const loadDataSets = async (pageNum, pageSize) => {
    const params = {
      pageNum: pageNum,
      pageSize: pageSize
    };
    datasetApi.list(params).then(res => {
      if (res.data.code === 0) {
        setTotal(res.data.data.total);
        setDataSets(res.data.data.list);
      } else {
        console.log(res.data.message);
      }
    });
  };

  useEffect(() => {
    // 加载数据集
    loadDataSets(currentPage, pageSize);
  }, []);

  const handlePageChange = (page, pageSize) => {
    setCurrentPage(page);
    setPageSize(pageSize);
    loadDataSets(page, pageSize);
  };

  const handleCardClick = (datasetId) => {
    navigate(`/knowledge/${datasetId}/list`);
  };

  return (
    <div style={{margin: '0 auto'}}>
      <List
        grid={{ gutter: 16, column: 3 }}
        dataSource={dataSets}
        renderItem={(dataSet) => (
          <List.Item>
            <Card title={dataSet.name} bordered={false} onClick={() => handleCardClick(dataSet.id)}>
              {dataSet.description}
            </Card>
          </List.Item>
        )}
      />
      <Pagination
        current={currentPage}
        pageSize={pageSize}
        total={total}
        onChange={handlePageChange}
        style={{ textAlign: 'center', marginTop: 16 }}
      />
    </div>
  );
};

export default DatasetList;