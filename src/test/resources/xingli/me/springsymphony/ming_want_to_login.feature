@txn
Feature:
  In order to create a post, as a new user, ming want to create a new account.
  传来为json数据
  登录方式: 用户名密码, 手机号获取密码, 邮箱获取密码, 手机号验证码, 邮箱验证码
  密码应该通过工具加密，返回结果也不应该包括密码

#  Scenario:
#    Given filling in the password "13434abc"
#    And filling the the username "ming"
#    When press the button signUp
#    Then he receive the status code "1"
##    And he receive the message "account created successfully"
  Scenario Outline: 用户名只能是英文和数字的组合,且不为空.最大16位
    Given filling in the password "12345678"
    And filling the the username "<username>"
    When press the button signUp
    Then he receive the status code "<code>"
    Examples:
      | username          | code |
      | abc               | 1    |
      | sdf23_            | 0    |
      | dfd+              | 0    |
      |                   | 0    |
      | 12345678901234567 | 0    |
      | 1234567890123456  | 1    |

  Scenario Outline: 密码长度小于八位 大于32位
    Given filling in the password "<password>"
    And filling the the username "add"
    When press the button signUp
    Then he receive the status code "<code>"
    Examples:
      | password                              | code |
      | 123                                   | 0    |
      | 1234567890345678956789078989898989089 | 0    |
      | 123456789                             | 1    |
      | 12345678                              | 1    |
  Scenario: 如果用户名重复，失败
    Given login with name "add" and password "12345678"
    And filling the the username "add"
    And filling in the password "123456789"
    When press the button signUp
    Then he receive the status code "0"
    And he receive the message "用户名重复"