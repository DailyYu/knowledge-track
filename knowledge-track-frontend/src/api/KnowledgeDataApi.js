
// 导入axios实例
import request from '../utils/request'
const apiMap = {
  list: list,
  delete: deleteById,
  update: update,
  add: add
}
export default apiMap


function list(params) {
  return request({
    url: '/knowledge/list',
    method: 'get',
    params: params
  })
}


function deleteById(id) {
  const params = {id: id}
  return request({
    url: '/knowledge/delete',
    method: 'get',
    params: params
  })
}


function update(params) {
  return request({
    url: '/knowledge/update',
    method: 'post',
    data: params
  })
}



function add(params) {
  return request({
    url: '/knowledge/add',
    method: 'post',
    data: params
  })
}