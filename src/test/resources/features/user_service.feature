Feature:

  Scenario Outline: 邮箱的格式
    Given get a example user
    And set email "<email>"
    When validate user
    Then get "<msg>"
    Examples:
      | email         | msg |
      | lxxdev@qq.com | yes |

  Scenario Outline: 用户名的格式
    Given get a example user
    And set name "<name>"
    When validate user
    Then get "<msg>"
    Examples:
      | name | msg |
      | xing | yes |
      | xing | no |

  Scenario Outline: 密码的格式
    Given get a example user
    And set password "<pwd>"
    When validate user
    Then get "<msg>"
    Examples:
      | pwd    | msg |
      | 123456 | yes |
      | xing | no |

#todo 测试用户名或邮箱不得重复
#todo 添加发送邮件的程序并测试
#todo 根据某个惟一值
  Scenario Outline: 根据链接即可验证成功,成功与否,失败信息
    Given set user "<name>",verify_id "<vId>"
    When call validate
    Then get "<response>"
    Examples:
      | name | vId | response |
      | abc  | 123 | yes      |
