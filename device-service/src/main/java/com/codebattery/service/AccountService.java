package com.codebattery.service;

import com.codebattery.domain.Account;
import com.codebattery.model.AccountInfo;
import com.codebattery.repository.AccountRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserService userService;

    /**
     * 获取所有account信息
     *
     * @return
     *
     * @athor Eric
     * @date 2020-02-09
     */
    public List<AccountInfo> listAll(){
//        $currentOrganizationCode = getCurrentOrganizationCode();
//        $where = [['organization_code', '=', $currentOrganizationCode]];
//        $where = [['organization_code', '=', $currentOrganizationCode], ['is_owner', '=', 0]];
//        $params = Request::only('account,mobile,email,searchType,keyword');
//        $departmentCode = Request::param('departmentCode');
//        if (isset($params['keyword']) && $params['keyword']) {
//            $where[] = ['name', 'like', "%{$params['keyword']}%"];
//        }
//        if (isset($params['searchType'])) {
//            $searchType = $params['searchType'];
//            switch ($searchType) {
//                case 1:
//                    $where[] = ['status', '=', 1];
//                    break;
//                case 2:
//                    $where[] = ['department_code', '=', ''];
//                    break;
//                case 3:
//                    $where[] = ['status', '=', 0];
//                    break;
//                case 4:
//                    $where[] = ['status', '=', 1];
//                    $where[] = ['department_code', 'like', "%{$departmentCode}%"];
//                    break;
//                default:
//                    $where[] = ['status', '=', 1];
//
//            }
//        }
//        foreach (['account', 'mobile', 'email'] as $key) {
//            (isset($params[$key]) && $params[$key] !== '') && $where[] = [$key, 'like', "%{$params[$key]}%"];
//        }
//        if (isset($params['date']) && $params['date'] !== '') {
//            list($start, $end) = explode('~', $params['date']);
//            $where[] = ['last_login_time', 'between', ["{$start} 00:00:00", "{$end} 23:59:59"]];
//        }

        List<Account> allAcountList = Lists.newArrayList(accountRepository.findAll());
        List<AccountInfo> accountInfoList = new ArrayList<>();
        for(Account account : allAcountList){
            AccountInfo info = new AccountInfo();

            info.setAvatar(account.getAvatar());
            info.setAuthorize(account.getAuthorize());
            info.setCode(account.getCode());
            info.setCreateTime(account.getCreateTime());
            info.setDepartment(account.getDepartment());
            info.setDepartmentCode(account.getDepartmentCode());
            info.setDescription(account.getDescription());
            info.setEmail(account.getEmail());
            info.setIsOwner(account.getIsOwner());
            info.setLastLoginTime(account.getLastLoginTime());
            info.setMemberCode(account.getMemberCode());
            info.setMobile(account.getMobile());
            info.setName(account.getName());
            info.setOrganizationCode(account.getOrganizationCode());
            info.setPosition(account.getPosition());
            info.setStatus(account.getStatus());

            accountInfoList.add(info);
        }

//        $list = $this->model->_list($where, 'id asc');
//        if ($list['list']) {
//            $organizaionCode = getCurrentOrganizationCode();
//            foreach ($list['list'] as &$item) {
//                $memberInfo = Member::where(['code' => $item['member_code']])->field('id', true)->find();
//                if ($memberInfo) {
//                    $item['avatar'] = $memberInfo['avatar'];
//                }
//                $memberAccount = MemberAccount::where(['member_code' => $memberInfo['code'], 'organization_code' => $organizaionCode])->field('code,status,authorize')->find();
//                $item['membar_account_code'] = $memberAccount ? $memberAccount['code'] : '';
//                $departments = [];
//                $departmentCodes = $item['department_code'];
//                if ($departmentCodes) {
//                    $departmentCodes = explode(',', $departmentCodes);
//                    foreach ($departmentCodes as $departmentCode) {
//                        $department = \app\common\Model\Department::where(['code' => $departmentCode])->field('name')->find();
//                        $departments[] = $department['name'];
//                    }
//                }
//                $item['departments'] = $departments ? implode(' - ', $departments) : '';
//            }
//            unset($item);
//        }
//        $list['authList'] = \app\common\Model\ProjectAuth::where(['status' => '1', 'organization_code' => $currentOrganizationCode])->select();


        return accountInfoList;
    }

}
