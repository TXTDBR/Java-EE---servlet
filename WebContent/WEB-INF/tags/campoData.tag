<%@	attribute name="id"  required="true"%>
<input type="text" id="${id}" name="${id}" value="${id}"/>
<script>
	$("#${id}").datepicker({dateFormat:	'dd/mm/yy'});
</script>