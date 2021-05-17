<%@page import="java.util.HashMap"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style type="text/css">
 body {
	background-image: url("/project0/resources/img/background.jpg");
    background-size: cover;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
} 
</style>

<script type="text/javascript">
function openNav() {
	  document.getElementById("mySidenav").style.width = "150px";
	  document.getElementById("menuB").style.visibility ="hidden";
	 /*  document.getElementById("AllBody").style.marginLeft ="20px"; */
	 
	}
function closeNav() {
	  document.getElementById("mySidenav").style.width = "0";
	  document.getElementById("menuB").style.visibility ="visible";
	  /* document.getElementById("AllBody").style.marginLeft ="-20px"; */
	} 


$(function() {
	$("#date").datepicker({
		/*  beforeShowDay:DisableSunday, */
		changeMonth : true,
		changeYear : true,
		yearRange : '1980:2001',
		/* dateFormat : 'dd-mm-yy',
 */	    /*minDate:0 */
	});
});
</script>

</head>
<body>
	<sf:form modelAttribute="form" method="post">
		<div class="container-fluid" align="center" >

			<aside class="col-sm-4">

				<div class="card shadow" align="center" >
					<article class="card-body">



						<h4 class="card-title text-center mb-4 mt-1"
							style="color: #C71585;">
							<s:message code="label.adduser"></s:message>
						</h4>

						<hr>

						<c:if test="${success != null}">
							<div class="alert alert-success alert-dismissible fade show">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<b>${success}</b>
							</div>
						</c:if>

						<c:if test="${error != null}">
							<div class="alert alert-danger alert-dismissible fade show">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<b>${error}</b>
							</div>
						</c:if>

						<sf:hidden path="id" />
						<sf:hidden path="createdBy" />
						<sf:hidden path="modifiedBy" />
						<sf:hidden path="createdDatetime" />
						<sf:hidden path="modifiedDatetime" />


						<div class="form-group">

							<div align="left" style="color: #8A2BE2;"
								for="validationDefault02">
								<s:message code="label.firstName" />
								<span style="color: red">*</span>
							</div>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-user"></i>
									</span>
								</div>


									<sf:input path="firstName" class="form-control"
									placeholder="${enterfirstName}"/>


							</div>
							<div align="left">
								<font style="color: red"><sf:errors path="firstName" /></font>
							</div>

						</div>

						<div class="form-group">

							<div align="left" style="color: #8A2BE2;"
								for="validationDefault02">
								<s:message code="label.lastName" />
								<span style="color: red">*</span>
							</div>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fas fa-user"></i></i>
									</span>
								</div>



								<sf:input path="lastName" class="form-control"
									placeholder="${enterLastName}" />


							</div>
							<div align="left">
								<font style="color: red"><sf:errors path="lastName" /></font>
							</div>

						</div>

						<div class="form-group">

							<div align="left" style="color: #8A2BE2;"
								for="validationDefault02">
								<s:message code="label.email" />
								<span style="color: red">*</span>
							</div>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i
										class="fas fa-envelope"></i>
									</span>
								</div>


								<sf:input path="login" class="form-control"
									placeholder="${enteremail}" />

							</div>
							<div align="left">
								<font style="color: red"><sf:errors path="login" /> </font>
							</div>

						</div>

						<div class="form-group">

							<div align="left" style="color: #8A2BE2;"validationDefault02">
								<s:message code="label.password" />
								<span style="color: red">*</span>
							</div>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-lock"></i>
									</span>
								</div>


								<sf:input type="password" path="password" class="form-control"
									placeholder="${enterpassword}" />



							</div>

							<div align="left">
								<font style="color: red"><sf:errors path="password" /></font>
							</div>
						</div>

						<div class="form-grou p">

							<div align="left" style="color: #8A2BE2;"validationDefault02">
								<s:message code="label.confirmpassword" />
								<span style="color: red">*</span>
							</div>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-lock"></i>
									</span>
								</div>

								<sf:input type="password" path="confirmPassword"
									class="form-control" placeholder="${enterconPassword}" />

							</div>

							<div align="left">
								<font style="color: red"><sf:errors
										path="confirmPassword" /> </font>
							</div>
						</div>

						<div class="form-group">

							<div align="left" style="color: #8A2BE2;"validationDefault02">
								<s:message code="label.role" />
								<span style="color: red">*</span>
							</div>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-lock"></i>
									</span>
								</div>

								
								<sf:select path="roleId" class="form-control">
									<sf:option value="0" label="${enterRoleName}">
										<s:message code="label.selectrole"></s:message>
									</sf:option>
									<sf:options items="${roleList}" itemValue="id" itemLabel="name"></sf:options>
								</sf:select>
								



							</div>

							<div align="left">
								<font style="color: red"><sf:errors path="roleId" /> </font>
							</div>
						</div>




						<div class="form-group">

							<div align="left" style="color: #8A2BE2;"
								for="validationDefault02">
								<s:message code="label.gender" />
								<span style="color: red">*</span>
							</div>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i
										class='fas fa-venus-double'></i></span>
								</div>


								
								<sf:select path="gender" class="form-control">

									<sf:option value="">
										<s:message code="label.selectgender"></s:message>
									</sf:option>
									<sf:options items="${genderList}" />


								</sf:select>




							</div>
							<div align="left">
								<font style="color: red"><sf:errors path="gender" /> </font>
							</div>

						</div>

						<div class="form-group">

							<div align="left" style="color: #8A2BE2;"
								for="validationDefault02">
								<s:message code="label.dob" />
								<span style="color: red">*</span>
							</div>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i
										class='fas fa-calendar-alt'></i></span>
								</div>


								<sf:input readonly="readonly" path="dob" class="form-control"
									id="date" placeholder="${enterdob}" autocomplete="off" />


							</div>
							<div align="left">
								<font style="color: red"><sf:errors path="dob" /> </font>
							</div>

						</div>

						<div class="form-group">

							<div align="left" style="color: #8A2BE2;"
								for="validationDefault02">
								<s:message code="label.mobileNo" />
								<span style="color: red">*</span>
							</div>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i
										class='fas fa-mobile-alt'></i></span>
								</div>


								<sf:input path="mobileNo" class="form-control"
									placeholder="${enterMobile}" />



							</div>
							<div align="left">
								<font style="color: red"><sf:errors path="mobileNo" />
								</font>
							</div>

						</div>
						<c:choose>
							<c:when test="${form.id==0}">
								<button type="submit" name="operation"
									style="float: left; width: 100px; margin-left: 50px;"
									value="save" class="btn btn-primary btn-block button2 msgBtn">
									<s:message code="label.save" />
								</button>


								<button type="submit" name="operation"
									style="width: 80px; margin-left: 150px;" value="reset"
									class="btn btn-primary btn-block button2">
									<s:message code="label.reset" />
								</button>
							</c:when>
							<c:otherwise>
								<button type="submit" name="operation"
									style="float: left; width: 100px; margin-left: 50px;"
									value="save" class="btn btn-primary btn-block button2 msgBtn">
									<s:message code="label.update" />
								</button>


								<button type="submit" name="operation"
									style="width: 80px; margin-left: 150px;" value="Cancel"
									class="btn btn-primary btn-block button2">
								 <s:message code="label.cancel" />
				 				</button>
							</c:otherwise>
						</c:choose>



					</article>
				</div>

			</aside>

		</div>
	</sf:form>
	<br><br><br>
</body>

</html>