Feature:
  In order to create a post, as a new user, ming want to create a new account.
  传来为json数据
  登录方式: 用户名密码, 手机号获取密码, 邮箱获取密码, 手机号验证码, 邮箱验证码

  Scenario:
    Given filling in the password "13434abc"
    And filling the the username "ming"
    When press the button signUp
    Then he receive the status code "1"
#    And he receive the message "account created successfully"

  Scenario: 用户名只能是英文和数字的组合

  Scenario: 密码长度小于八位 大于32位

  Scenario: 如果用户名重复，失败

#  Scenario: 传过来的值是json数据