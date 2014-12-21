<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  New Timer
</button>

<form:form commandName="timer" cssClass="form-horizontal blogForm">
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">New Timer</h4>
      </div>
      <div class="modal-body">
		  <div class="form-group">
		    <label for="name" class="col-sm-2 control-label">Name:</label>
		    <div class="col-sm-10">
		      <form:input path="name" cssClass="form-control"/>
		      <form:errors path="name" />
		    </div>
		  </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" class="btn btn-primary" value="Save" />
      </div>
    </div>
  </div>
</div>
</form:form>

<br /><br />

<script type="text/javascript">
$(document).ready(function() {
	$('.nav-tabs a:first').tab('show'); // Select first tab when page is loaded	
	$('.triggerRemove').click(function(e) {
		e.preventDefault();
		$('#modalRemove .removeBtn').attr("href", $(this).attr("href"));
		$('#modalRemove').modal();
	});
	$(".blogForm").validate(
			{
				rules: {
					name: {
						required : true,
						minlength : 1
					},
				},
				highlight: function(element) {
					$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
				},
				unhighlight: function(element) {
					$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
				},
			}	
		)
});
</script>

<div role="tabpanel">

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
	<c:forEach items="${user.timers}" var="timer">
    	<li><a href="#timer_${timer.id}" aria-controls="home" role="tab" data-toggle="tab">${timer.name}</a></li>
    </c:forEach>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <c:forEach items="${user.timers}" var="timer">
    <div class="tab-pane" id="timer_${timer.id}">
    		<h1>${timer.name}</h1>
			<p>
			<a href="<spring:url value="/timer/remove/${timer.id}.html" />" class="btn btn-danger triggerRemove">remove timer</a>
			${timer.name}
			</p>
    </div>
    </c:forEach>
  </div>

</div>

<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove timer</h4>
      </div>
      <div class="modal-body">
        Really remove?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>