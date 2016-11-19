$(document).ready(
		function() {
			$('#example').DataTable();
			$('#tableChiKhac').DataTable();
			$('#table2').DataTable();
			$('#table3').DataTable();
			$('.date-picker').datepicker({
				changeMonth : true,
				changeYear : true,
				dateFormat : 'dd/mm/yy',
			}).click(function() {
				$('.ui-datepicker-calendar').show();
			});
			$('.date-picker-month').datepicker(
					{
						changeMonth : true,
						changeYear : true,
						showButtonPanel : true,
						dateFormat : 'mm/yy',
						onChangeMonthYear : function(year, month, widget) {
							setTimeout(function() {
								$('.ui-datepicker-calendar').hide();
							});
						},
						onClose : function(dateText, inst) {
							$(this).datepicker(
									'setDate',
									new Date(inst.selectedYear,
											inst.selectedMonth, 1));

						}
					}).click(function() {
				$('.ui-datepicker-calendar').hide();
			});
			$(".resetField").click(function() {
				$(".searchField").val("");
			});
		});