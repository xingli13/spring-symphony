Feature:
  In order to create a post, as a new user, ming want to create a new account.
  1. 对于用户名、密码验证
  2. 储存的密码为加密的
  3. 用户名不可重复
  4. 登录方式：邮箱、用户名、密码登录

  Scenario Outline password: 当前简单密码验证
    Given password is <password>
    When validate
    Then binding result is <isNull>
    And message is <msg>
    Examples:
      | password                              | isNull | msg              |
      | abc                                   | false  | invalid password |
      | 1234567890345678956789078989898989089 | false  | invalid password |
      | 12345678                              | true   |                  |
