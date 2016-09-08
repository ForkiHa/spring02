package spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import spring.model.Address;
import spring.model.MemberInfo;

public class MemberInfoValidator implements Validator{

	public boolean supports(Class<?> clazz){
		return MemberInfo.class.isAssignableFrom(clazz);
	} //���ϰ��� true�ϰ�츸 validate(Object target, Errors errors) ����
	
	public void validate(Object target, Errors errors){
		MemberInfo memberInfo = (MemberInfo) target;
		if(memberInfo.getId() == null || memberInfo.getId().trim().isEmpty()){
			//trim() :  ��������
			errors.rejectValue("id", "required");
			//id��� �̸��� required��� key���� ���� �����ڵ带 ��½�Ű�ڴ�.
		}
		if (memberInfo.getName() == null || memberInfo.getName().trim().isEmpty()) {
			errors.rejectValue("name", "required");
		}
		Address address = memberInfo.getAddress();
		if (address == null) {
			errors.rejectValue("address", "required");
		}
		if (address != null) {
			errors.pushNestedPath("address");
			try{
				if(address.getZipcode()==null||address.getZipcode().trim().isEmpty()){
					errors.rejectValue("zipcode", "required");
				}
				if(address.getAddress1() == null || address.getAddress1().trim().isEmpty()){
					errors.rejectValue("address1", "required");
				}
			}finally{
				errors.popNestedPath();
			}
		}
	}
}
